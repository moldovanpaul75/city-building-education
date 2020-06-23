package Business;

public class LayerType {
    private int layerId;
    private String layerName;

    public LayerType(int id, String name) {
        this.layerId = id;
        this.layerName = name;
    }

    public LayerType(String name) {
        this.layerName = name;
    }

    public void setLayerId(int id) {
        this.layerId = id;
    }

    public int getLayerId() {
        return this.layerId;
    }

    public void setLayerName(String name) {
        this.layerName = name;
    }

    public String getLayerName() {
        return this.layerName;
    }

    public String toString() {
        return "layer type: " + this.layerId + " " + this.layerName;
    }
}
