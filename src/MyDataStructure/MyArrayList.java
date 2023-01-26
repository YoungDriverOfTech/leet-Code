package MyDataStructure;

public class MyArrayList {

    private final static int DEFAULT_CAPACITY = 10;

    // properties
    private int[] elements;

    private int capacity;

    private int size = 0;

    // constructors
    public MyArrayList() {
        this.elements = new int[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("Capacity value must be positive.");
        }else if (capacity < DEFAULT_CAPACITY) {
            this.elements = new int[DEFAULT_CAPACITY];
            this.capacity = DEFAULT_CAPACITY;
        } else {
            this.elements = new int[capacity];
            this.capacity = capacity;
        }
    }

    // methods

    /**
     * Add element into array
     * @param index element index
     * @param value element value
     */
    public void add(int index, int value) {

    }

    /**
     * Add value into last position of array list
     * @param value element value
     */
    public void add(int value) {

    }

    /**
     * Remove the element by index
     * @param index element index
     */
    public void remove(int index) {

    }

    /**
     *
     * @param value element value
     */
    public void removeByValue(int value) {

    }

    /**
     * Replace element value by index
     * @param index element index
     * @param value element value
     */
    public void set(int index, int value) {
        rangeCheck(index);
        elements[index] = value;
    }



    /**
     * Get element by index
     * @param index element index
     * @return element value
     */
    public int get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * Get first element value equals with parameter value
     * @param value element value
     * @return element index
     */
    public int getFirstElementByValue(int value) {
        return 0;
    }

    /**
     * Get the length of array list
     * @return the length of array
     */
    public int length() {
        return size;
    }

    /**
     * Whether array list is empty
     * @return true/false
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Check index validity
     * @param index element index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Invalid index: " + index);
        }
    }
    public static void main(String[] args) {

    }
}
