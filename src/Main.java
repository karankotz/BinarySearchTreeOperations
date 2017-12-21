import java.util.Scanner;

import static java.lang.System.exit;

//Class for the node of the tree to be built
class BNode {
    //the left and the right pointers that need to be initialized
    BNode left, right;
    int data;
    //empty constructor to initialize the node at the start
    public BNode()
    {
       left = null;
       right = null;
       data = 0;
    }
    //Constructor with the parameter n to initialize the data while we initalize the node
    public BNode(int n)
    {
        left = null;
        right = null;
        data =n;
    }


}

class BTree
{
    //sum variable that will be used for the greater sum tree
    static int sum = 0;
    //count variable to calculate the size of the tree
    int count;
private BNode root;

//Constructor that will set the root node to be null at first when the object of the class BTree is initialized.
public BTree()
{

    root = null;
}

//check if the tree is empty this is out of the scope

    public int isEmpty()
    {
        //if the root is null then the tree will be empty so we are going to return 1
        if(root == null)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    //insert function for initilaizing the new node and which inturn calls the insert fucntion
    // to insert the new node into the tree
    public void insert(int data)
    {
        //create a new node for the binary tree and assign it to the z
        BNode z  = new BNode(data);
        //Call the insert function that is defined below which will insert the node into the
        insert(root, z);
    }

    private void insert(BNode node, BNode z)
    {
        //Initialize the node to record the parent of the x
        BNode y = null;
        //Get the root node to traverse from x
        BNode x = root;
        //Repeat untill x is not null, i.e.. untill the tree doesn't reach the end node and the root is not null
        //The purpsoe of this loop is to find the position where to insert the node
        while(x != null)
        {
            //record the parent node of x
            y = x;
            //Then compare if the data of the node that is to be inserted is less than the current node
            //if it is less than the current node then move the x to the left
            if(z.data < x.data )
            {
                x = x.left;
            }
            //if the data of the node to be inserted is more than the current node then move to the right
            else
            {
                x = x.right;
            }
        }
        //if the parent node is null then we make the node to be inserted as the root as the tree will be empty
        if(y == null)
        {
            root = z;
        }
        //if the data of the node to be inserted is less than the y node then we set the y's left to be z
        else if (z.data < y.data)
        {
            y.left = z;
        }
        //if the data of the z node to be inserted is more than the
        else
        {
            y.right = z;
        }
        //increament the count after inserting the node
        count ++;
    }

    //Check if the data is same for any fo the node that is present
    //if the data is present then the function returns true else false.
    public Boolean contains(int k)
    {
        //set the root node as the x
        BNode x = root;
        //Then traverse from the root node and reach the node in a faster way with the help of the BST property
        while(x != null )
        {
            //if the key k is equal to the node x data
            if(k == x.data)
            {
                return Boolean.TRUE;
            }
            //if the key k is less than the node x data it will be in the left subtree
            if(k < x.data)
            {
                x = x.left;
            }
            //if the key k is greater than the node x data it will be in the right subtree
            else
            {
                x = x.right;
            }
        }
        //return false if we don't find the node with the data that is equal to the key k
        return Boolean.FALSE;
    }
    //return the smallest element of the tree via smallest method
    public int smallest()
    {
        //set the x to the root node
        BNode x = root;
        //Traverse until the end of the tree to the left untill x.left not equal to null
        while(x.left != null)
        {
            x = x.left;
        }
        //return the last left node data as it will be the smallest (by the property of the binary tree)
        return x.data;
    }
    //return the largest element of the tree via the maximum method
    public int maximum()
    {
        //Set the x as the root node
        BNode x =root;
        //Now traverse the tree till the right until the x.right is not equal to the null
        while(x.right != null)
        {
            x = x.right;
        }
        //return the last right node as this will be the maximum element in the tree.
        return x.data;
    }
    //Parent function which calls the inorder(x) which in turn prints the tree in the inorder traversal
    public void print()
    {
        //Set the x to the root node
        BNode x = root;
        //Which is the actual function to print the data of the tree in the inorder traversal
        inorder(x);
    }
//Traverse in the inorder and print the node data in the inorder
    public void inorder(BNode x)
    {
        //if the is not null then we are traversing recursively
        if(x != null)
        {
            //recursive call to traverse recursively towards the left
            inorder(x.left);
            //print the data of the node
            System.out.println(x.data);
            //traverse the node recursively towards the right
            inorder(x.right);
        }
    }
    //Here we are returning the count of the no of noded that we have kept the count while we are inserting each node
    public int size()
    {
        return count;
    }

    public int size1()
    {
        BNode x = root;
        int z = size2(x);
        return z;
    }

    public int size2(BNode x)
    {
        if (x == null)
            return 0;
        else
            return(size2(x.left) + 1 + size2(x.right));
    }

//Greater Sum tree function to transform the BST to the Greater sum tree
    public void greatersumtree()
    {
        //set the root node to the x
        BNode x = root;
        //Transform the tree while we pass the root node of the tree
        transform(x);
    }
    //Transform method that will be used to transform the tree with the greater sum tree
    public void transform(BNode x)
    {
        //Base conditions, i.e.. the function will return if the node is equal to null or it will continue
        if(x == null)
            return;
        //traverse to the right as we will start from the right because the maximum element will be to the right of the tree
        transform(x.right);
        //Sum the data of the node encountered with the sum variable
        sum = sum + x.data;
        //We need to set the sum of all the other nodes excluding the data of the present node which we are writing to
        x.data = sum - x.data;
        //Again call recursively to transform the tree and start from the left node of the present node
        transform(x.left);
    }



}

public class Main
{
    public static void main(String[] args)
    {
        //Create an object b1 of the BTree class that we have defined above
        BTree b1 = new BTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter 1  the below options\n");
        System.out.println("1.Binary tree operations\n");

        int  ch1 = 1;

        do {

            System.out.println("\nBinary Search Tree Operations\n");

            //give the choice to the user to select the options recursively
            System.out.println("1. insert ");
            System.out.println("2. Contains");
            System.out.println("3. Print");
            System.out.println("4. Size");
            System.out.println("5. Smallest");
            System.out.println("6. Largest");
            System.out.println("7. Transform BST to greater Sum tree");
            System.out.println("8. Exit");

            //Read option
            int option = sc.nextInt();
            switch (option)
            {
                case 1:
                    //Call insert function with the data read from the user
                    System.out.println("Enter data to insert into BST");
                    b1.insert(sc.nextInt());
                    break;

                case 2:
                    //Here we print true if the element is present or else we return false
                    System.out.println("Enter the data to search if it is present");
                    System.out.println(b1.contains(sc.nextInt()));
                    break;

                case 3:
                    //Here we print the elements of the tree in inorder
                    System.out.println("Printing the data in the inorder\n");
                    b1.print();
                    break;

                case 4:
                    //Here we print the size of the tree, i.e.. no of the nodes in the tree
                    System.out.println("The size of the tree is :"+b1.size1()+" \n");
                    break;

                case 5:
                    //Here we print the smallest element in the tree
                    System.out.println("The smallest element in the tree is \n");
                    System.out.println(b1.smallest());
                    break;
                case 6:
                    //Here we print the largest element in the tree
                    System.out.println("The largest element in the tree is \n");
                    System.out.println(b1.maximum());
                    break;
                case 7:
                    //Transform the tree by calling the greatersumtree method
                    System.out.println("Transforming to the greater sum tree\n");
                    b1.greatersumtree();
                    System.out.println("Transformation Complete select print to view the resulting tree\n");
                    break;

                case 8:
                    //Exit if choice is 8
                    System.out.println("Exiting\n");
                    exit(0);
                    break;

                default:
                    //Default
                    System.out.println("Invalid Option\n ");
                    break;

            }

        /*
        //Static Input
        b1.insert(5);
        b1.insert(4);
        b1.insert(6);

        System.out.println(b1.contains(4));
        System.out.println(b1.contains(10));
        b1.print();
        System.out.println( b1.smallest());
        System.out.println( b1.maximum());
        System.out.println("Size of the tree is "+b1.size());
        b1.greatersumtree();
        b1.print();
        */
        } while(ch1 == 1);
    }
}
