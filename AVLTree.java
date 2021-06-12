// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman, Modified by Sanele Hlongwane
// reference: kukuruku.co/post/avl-trees/

public class AVLTree extends BinaryTree
{
   int counter = 0;
   int insertCount = 0;
   public int height ( BinaryTreeNode node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   public int balanceFactor ( BinaryTreeNode node )
   {
      return height (node.right) - height (node.left);
   }
   
   public void fixHeight ( BinaryTreeNode node )
   {
      insertCount+=1;
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   public BinaryTreeNode rotateRight ( BinaryTreeNode p )
   {
      insertCount+=1;
      BinaryTreeNode q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public BinaryTreeNode rotateLeft ( BinaryTreeNode q )
   {
      insertCount+=1;
      BinaryTreeNode p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   public BinaryTreeNode balance ( BinaryTreeNode p )
   {
      insertCount+=1;
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         insertCount+=1;
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         insertCount+=1;
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   public void insert ( String d )
   {
      root = insert (d, root);
   }
   public BinaryTreeNode insert ( String d, BinaryTreeNode node )
   {
      if (node == null){
         insertCount+=1;
         return new BinaryTreeNode (d, null, null);}
      if (d.compareTo (node.data) <= 0){
         insertCount+=1;
         node.left = insert (d, node.left);}
      else{
         insertCount+=1;
         node.right = insert (d, node.right);}
      return balance (node);
   }
   
   public void delete ( String d )
   {
      root = delete (d, root);
   }   
   public BinaryTreeNode delete ( String d, BinaryTreeNode node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else
      {
         BinaryTreeNode q = node.left;
         BinaryTreeNode r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   
   public BinaryTreeNode findMin ( BinaryTreeNode node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   public BinaryTreeNode removeMin ( BinaryTreeNode node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   public BinaryTreeNode find ( String d )
   {
      if (root == null){
         counter++;
         return null;}
      else{
         counter++;
         return find (d, root);}
   }
   public BinaryTreeNode find ( String d, BinaryTreeNode node )
   {
      if (d.compareTo (node.data.split(" ", 2)[0]) == 0){
         counter++;
         return node;}
      else if (d.compareTo (node.data.split(" ", 2)[0]) < 0){
         counter++;
         return (node.left == null) ? null : find (d, node.left);}
      else{
         counter++;
         return (node.right == null) ? null : find (d, node.right);}
   }
   
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( BinaryTreeNode node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}

