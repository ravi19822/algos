package stack;

public class StackUsingArray {

    private int[] arr;
    private int top=-1;
    private int currsize=0;
    private int maxsize;

    public StackUsingArray( int maxsize) {
        this.maxsize = maxsize;
        arr=new int[maxsize];
    }
    public void push(int data)
    {
        if(top==maxsize-1)
        {
            System.out.println("Stack is full!!! Nothing can be added further");
        }
        else
        {
            arr[++top]=data;
            currsize++;
        }

    }

    public int pop()
    {
        if(top==-1)
        {
            System.out.println("Stack is Empty!!! Nothing to be returned");
        }
        else
        {
            int data=arr[top];
            top--;
            currsize--;
            return data;
        }
     return -1;
    }
    public int getCurrsize()
    {
        return currsize;
    }

    public static void main(String[] args) {
        System.out.println("Stack Implementation using Array");
        StackUsingArray st =new StackUsingArray(5);
        st.push(10);
        st.push(15);
        st.push(20);
        st.push(25);
        st.push(30);
        st.push(35);
        System.out.println(" Popping "+st.pop());
        st.push(5);
        System.out.println(" Size of stack is  "+st.getCurrsize());



    }
}
