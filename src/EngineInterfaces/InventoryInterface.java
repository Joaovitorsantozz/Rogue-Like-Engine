package EngineInterfaces;

import GameObject.GameObject;

public interface InventoryInterface {

    public int getSize();
    public int getMaxSize();
    public GameObject getObjectIndex(int index);
}
