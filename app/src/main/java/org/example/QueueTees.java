package org.example;

public class QueueTees{
  private Cutie[] cutieArray;

  private int first;
  private int last;
  private int size;
  private int count;

  public QueueTees(int size){
    this.size = size;
    this.cutieArray = new Cutie[size];
    first = 0;
    last = -1;
    count = 0;
  }

  public void enqueue(Cutie cutie){
    if (count == size) {
      System.out.println("Queue is full. cannot add " + cutie.description());
      return;
    }

    last = (last + 1) % size;
    cutieArray[last] = cutie;
    count++;
  }

  public Cutie dequeue() {
    if (count == 0) {
      System.out.println("Queue is empty. nothing to dequeue.");
      return null;
    }

    Cutie removed = cutieArray[first];
    first = (first + 1) % size;
    count--;
    return removed;
  }

  public int size() {
    return count;
  }
}