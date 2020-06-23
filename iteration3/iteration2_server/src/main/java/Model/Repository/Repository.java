package Model.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

/**
 * This class manages the repository operations.
 */
public class Repository {

    private EntityManager entityManager;

    public Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     *
     * @param clazz
     * @param id
     * @return
     */
    public Optional<? extends Object> findById(Class clazz, Integer id) {
        Object obj = entityManager.find(clazz, id);
        return obj != null ? Optional.of(obj) : Optional.empty();
    }

    /**
     *
     * @param clazz
     * @return
     */
    public List findAll(Class clazz) {
        return entityManager.createQuery("from " + clazz.getSimpleName()).getResultList();
    }

    /**
     *
     * @param object
     * @return
     */
    public Optional<? extends Object> persist(Object object) {
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(object);
            entityTransaction.commit();

            return Optional.of(object);
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     *
     * @param object
     * @return
     */
    public Optional<? extends Object> merge(Object object) {
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            object = entityManager.merge(object);
            entityTransaction.commit();

            return Optional.of(object);
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    /**
     *
     * @param clazz
     * @param id
     * @return
     */
    public Optional<? extends Object> removeById(Class clazz, Integer id) {
        Optional<? extends Object> object = this.findById(clazz, id);
        object.ifPresent(o -> {
            EntityTransaction entityTransaction = null;
            try {
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                entityManager.remove(o);
                entityTransaction.commit();
            } catch (Exception e) {
                if (entityTransaction != null) {
                    entityTransaction.rollback();
                }
                e.printStackTrace();
            }
        });
        return Optional.empty();
    }

    /**
     *
     * @param clazz
     * @param object
     * @return
     */
    public Optional<? extends Object> remove(Class clazz, Object object) {
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(object);
            entityTransaction.commit();

            return Optional.of(object);
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
