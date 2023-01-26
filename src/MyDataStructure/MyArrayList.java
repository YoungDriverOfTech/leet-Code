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
        rangeCheckForAdd(index);

        // resize
        if (size == capacity) {
            resize(2 * size);
        }

        for (int i = index; i < size; i++) {
            // todo fix out of index
            elements[i + 1] = elements[i];
        }
        elements[index] = value;
        size++;
    }

    /**
     * Dynamic grow list length
     */
    private void resize(int capacity) {
        // Create a new array
        int[] newElements = new int[capacity];

        // Copy
        for (int i = 0; i < size; i++) {
            int value = elements[i];
            newElements[i] = value;
        }

        elements = newElements;
        this.capacity = capacity;
    }

    /**
     * Add value into last position of array list
     * @param value element value
     */
    public void add(int value) {
        add(size, value);
    }

    /**
     * Remove the element by index
     * @param index element index
     * @return removed element
     */
    public int remove(int index) {
        rangeCheck(index);

        int toRemoved = elements[index];

        // Remove elements
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;

        return toRemoved;
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

    /**
     * Check index validity for add
     * @param index element index
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Invalid index: " + index);
        }
    }

    public static void main(String[] args) {

    }
}
