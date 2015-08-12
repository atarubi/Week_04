/**
 * Class InsertionSort demonstrates Heap sort algorithm.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */

import java.util.Scanner;

public class HeapSort
{
    /**
     * Constructor for objects of class HeapSort
     */
    public HeapSort()
    {
    }

    public static void print_array(int [] a)
    {
        for (int i=0; i<a.length; i++)
        {
           System.out.print(a[i]+" ");
        }        
        System.out.println(" ");
    }

    public static int LeftChild(int i)
    {
        return 2*i+1;
    }

    public static int RightChild(int i)
    {
        return 2*i+2;
    }

    /**
    * This method implements the TrickleDown algorithm.
    * 
    * Input: Binary tree A of the size n starting from 0, 
    *        i is the node to be trickle down.
    * Output: Tree A becomes max heap.
    * 
    * @author (nxthang) 
    * @version (1.0)
    */
    
    public static void TrickleDown(int[] a, int n, int i)
    {
        int l=LeftChild(i);
        int r=RightChild(i);
        int maxpos=i;
        if ((l<n)&&(a[l]>a[maxpos]))
            maxpos=l;
        if ((r<n)&&(a[r]>a[maxpos]))
            maxpos=r;
        if (maxpos != i)
        {
            int tmp=a[i];
            a[i]=a[maxpos];
            a[maxpos]=tmp;
            TrickleDown(a,n,maxpos);
        }
    }
    
    /**
    * This method implements the BuildHeap algorithm.
    * 
    * Input:  An array A of the size n, starting from 0.
    * Output: A becomes max heap.
    * 
    * @author (nxthang) 
    * @version (1.0)
    */
    
    public static void BuildHeap(int[] a, int n)
    {
        for (int i=n/2; i>=0; i--)
        {
            TrickleDown(a,n,i);
        }
    }

    /**
    * This method implements the Heap sort algorithm.
    * 
    * Input:  An array A.
    * Output: A is sorted.
    * 
    * @author (nxthang) 
    * @version (1.0)
    */
    
    public static void Heap_Sort(int[] a)
    {
        int n=a.length;
        BuildHeap(a,n);
        System.out.println("Array a now becomes a max heap:");       
        print_array(a);
        
        for (int i=n-1; i>0; i--)
        {
            int tmp=a[0];
            a[0]=a[i];
            a[i]=tmp;
            n=n-1;
            TrickleDown(a,n,0);
            System.out.println("Array a now becomes a max heap:");       
            print_array(a);            
        }
    }
    public static void main()
    {
        int n;
        int [] a; 
        
        System.out.println("Please input the integer N:");
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();        

        a=new int[n];
        
        for (int i=0; i<n; i++)
        {
            System.out.println("Please input the integer a["+i+"]:");
            a[i]=scanner.nextInt();
        }        
        
        System.out.println("The list of integers is: ");
        print_array(a);

        Heap_Sort(a);
        
        System.out.println("The list of sorted integers is: ");       
        print_array(a);
    }    
}
