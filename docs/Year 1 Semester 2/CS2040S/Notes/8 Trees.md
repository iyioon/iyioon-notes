# Trees

## Balancing AVL Tree after Insertion

1. Walk up the tree and find the first unbalance node
2. If the node is left heavy
	1. If the left subtree is left heavy
		1. Right rotaation
	2. If the left subtree is right heavy
		1. Left rotation of the right subtree, then a right rotation of the node

## Balancing AVL Tree after Deletion

- Delete key from BST.
- Walk up tree:
- At every step, check for balance.
- If out-of-balance, use rotations to rebalance.
- Continue to root.

