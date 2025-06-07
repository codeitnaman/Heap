import java.util.*;

class MinHeap {
    private List<Integer> list;
    private int size;

    public MinHeap() {
        list = new ArrayList<>();
        size = 0;
    }

    private void swap(int i, int j) {
        int ith = list.get(i);
        int jth = list.get(j);
        list.set(i, jth);
        list.set(j, ith);
    }

    private void upheapify(int childIndex) {
        if (childIndex == 0) {
            return;
        }

        int parentIndex = (childIndex - 1) / 2;
        if (list.get(parentIndex) > list.get(childIndex)) {
            swap(parentIndex, childIndex);
            upheapify(parentIndex);
        }
    }

    private void downheapify(int parentIndex) {
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;
        if (leftIndex < size && list.get(leftIndex) < list.get(parentIndex)) {
            swap(leftIndex, parentIndex);
            downheapify(leftIndex);
        }

        if (rightIndex < size && list.get(rightIndex) < list.get(parentIndex)) {
            swap(rightIndex, parentIndex);
            downheapify(rightIndex);
        }
    }

    public void add(int nums) {
        list.add(nums);
        size++;
        upheapify(size - 1);
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return list.get(0);
    }

    public int remove() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        swap(0, size - 1);
        int element = list.remove(size - 1);
        size--;
        downheapify(0);
        return element;
    }

    public int size() {
        return size;
    }
}

public class Heap {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        System.out.println(minHeap.remove()); 
        minHeap.add(10);
        minHeap.add(25);
        minHeap.add(3);
        System.out.println(minHeap.peek());
        System.out.println(minHeap.remove());
        minHeap.add(1234);
        System.out.println(minHeap.peek());
        System.out.println(minHeap.size());
        minHeap.add(12);
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        minHeap.add(1);
        minHeap.add(12);
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
    }
}