package stqu;

import java.util.*;

public class SetOfStack {
  private Stack<Stack<Integer>> set = new Stack<>();
  private int capacity;

  public SetOfStack(int capacity) {
    this.capacity = capacity;
  }

  public void push(int data) {
    Stack<Integer> top;
    if(set.isEmpty()) {
      top = new Stack<Integer>();
      set.push(top);
    } else {
      top = set.peek();
      if(top.size() == capacity) {
        top = new Stack<Integer>();
        set.push(top);
      }
    }
    top.push(data);
  }

  public int pop() {
    if(set.peek().isEmpty()) {
      set.pop();
    }
    return set.peek().pop();
  }

  public static void main(String... s) {
    SetOfStack ss = new SetOfStack(3);
    ss.push(1);
    ss.push(2);
    ss.push(3);
    ss.push(4);
    ss.push(5);
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());
    System.out.println(ss.pop());

  }
}
