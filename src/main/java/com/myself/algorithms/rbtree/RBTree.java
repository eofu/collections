package com.myself.algorithms.rbtree;

/**
 * 红黑树
 * @param <K>
 * @param <V>
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private RBNode<K, V> root;

    // 左旋
    private void leftRotated(RBNode<K, V> p) {
        if (p != null) {
            RBNode<K, V> r = p.right;

            p.right = r.left;
            // 换爹
            if (r.left != null) {
                r.left.parent = p;
            }
            r.parent = p.parent;

            // 考虑向上节点状况
            if (p.parent == null) {
                root = r;
            } else if (p.parent.left == p) {
                p.parent.left = r;
            } else {
                p.parent.right = r;
            }

            r.left = p;
            p.parent = r;
        }
    }

    //右旋
    private void rightRotated(RBNode<K, V> p) {
        if (p != null) {
            RBNode<K, V> r = p.left;

            // 换爹
            if (p.parent == null) {
                r.parent = null;
            } else if (p.parent.right == p) {
                r.parent = p.parent.right;
            } else {
                r.parent = p.parent.left;
            }

            p.left = r.right;
            r.right = p;

            p.parent = r;
        }
    }

    // 插入
    public RBNode<K, V> put(int key) {
        RBNode<K, V> node = new RBNode(key, null);

        // 插入为根节点
        if (root == null) {
            root = node;
            return root;
        }
        RBNode<K, V> root = this.root;

        RBNode<K, V> p;
        int cmp;
        do {
            p = root;
            cmp = node.key.compareTo(p.key);
            if (cmp > 0) {
                p = p.right;
            }
            if (cmp < 0) {
                p = p.left;
            }
            // 相等替换
            if (cmp == 0) {
                p = node;
            }
        } while (p != null);

        if (cmp > 0) {
            p.right = node;
        }
        if (cmp < 0) {
            p.left = node;
        }
        node.parent = p;
        fixAfterInsertion(node);
        return p;
    }

    // 删除
    public RBNode<K, V> remove(K key) {
        RBNode<K, V> node = getRBNode(key);
        if (node == null) {
            return null;
        }
        deleteRBNode(node);
        return node;
    }

    private void deleteRBNode(RBNode<K, V> node) {
        // 3、有两个子节点
        if (rightOf(node) != null && leftOf(node) != null) {
            RBNode<K, V> secessor = secessor(node);
            node.key = secessor.key;
            node.value = secessor.value;
            // 改变指针到后继节点上
            node = secessor;
        }

        // 因为是后继节点，为空是指向左节点，此时左节点必定为空
        //          5
        //         /\
        //        3  8
        //			  \
        //		       10
        RBNode<K, V> replacementNode = leftOf(node) == null ? leftOf(node) : rightOf(node);
        // 2、只有一个子节点。替代节点不为空。
        if (replacementNode != null) {
            // 变爹
            replacementNode.parent = node.parent;
            // node为根节点
            if (node.parent == null) {
                root = replacementNode;
            }
            // node为左孩子
            else if (node == node.parent.left) {
                node.parent.left = replacementNode;
            }
            // node为右孩子
            else {
                node.parent.right = replacementNode;
            }
            // 将node的所有相关指针置空，node即为游离状态，等待垃圾回收器回收
            node.left = node.right = node.parent;

            // 调整平衡
            if (colorOf(node) == BLACK) {
                // 替代节点必为红色，变色即可
                fixAfterDeletion(replacementNode);
            }
        }
        // 4、删除的为根节点
        else if (node.parent == null) {
            root = null;
        }
        // 1、叶子节点直接删除
        else {
            // 如果是黑色，先调整
            if (colorOf(node) == BLACK) {
                fixAfterDeletion(node);
            }
            // 再删除
            if (node.parent != null) {
                if (node == node.parent.left) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
                node.parent = null;
            }
        }

    }

    private void fixAfterDeletion(RBNode<K, V> node) {
        while (node != root && node.color == BLACK) {
            // 为左节点情况
            if (node == leftOf(parentOf(node))) {
                // 红黑树上的兄弟节点
                RBNode<K, V> ribro = rightOf(parentOf(node));

                // 将2-3-4树上的兄弟节点，转化为红黑树上的兄弟节点
                if (colorOf(ribro) == RED) {
                    setColor(ribro, BLACK);
                    setColor(parentOf(node), RED);
                    leftRotated(parentOf(node));
                    // 兄弟节点改变
                    ribro = rightOf(parentOf(node));
                }

                // 兄弟节点的左右节点为空
                if (colorOf(leftOf(ribro)) == BLACK &&
                        colorOf(rightOf(ribro)) == BLACK) {
                    setColor(ribro, RED);
                    node = parentOf(node);
                } else {
                    // 兄弟节点为2-3-4树上的3-节点，即只有一个可借节点
                    //  	4               4
                    // 	    /\              /\
                    //    2   7  ————>     2  5
                    // 	     /                 \
                    //      5                   7
                    if (colorOf(leftOf(ribro)) == BLACK) {
                        setColor(ribro, RED);
                        setColor(rightOf(ribro), BLACK);
                        // 右旋后，可借节点置于右侧
                        rightRotated(ribro);
                        // 兄弟节点改变
                        ribro = rightOf(parentOf(node));
                    }
                    // 父节点不一样是红色
                    setColor(ribro, colorOf(parentOf(node)));
                    setColor(parentOf(node), BLACK);
                    setColor(rightOf(ribro), BLACK);
                    leftRotated(parentOf(node));

                    // 与循环判断想跟，结束循环
                    node = root;
                }
            }
            // 为右节点
            else {
                // 方向改变，省略
            }

        }
        // 补偿删除的黑色节点
        setColor(node, BLACK);
    }

    // 获取节点
    private RBNode<K, V> getRBNode(K key) {
        RBNode<K, V> p = root;
        int i;
        while (p != null) {
            i = p.key.compareTo(key);
            if (i > 0) {
                p = p.right;
            } else if (i < 0) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    // 插入后调整
    private void fixAfterInsertion(RBNode<K, V> node) {
        setColor(node, RED);
        // 2、父节点为红色时需要调整
        while (node != null && node != root && colorOf(parentOf(node)) == RED) {
            // 2.1、节点的父节点为爷爷节点的左孩子
            if (parentOf(node) == leftOf(parentOf(parentOf(node)))) {
                RBNode<K, V> y = rightOf(parentOf(parentOf(node)));
                // 2.11、叔叔节点为红色
                if (colorOf(y) == RED) {
                    // 父节点设黑
                    setColor(parentOf(node), BLACK);
                    // 叔叔节点设黑
                    setColor(y, BLACK);
                    // 祖父节点设红
                    setColor(parentOf(parentOf(node)), RED);
                    // 递归向上处理
                    node = parentOf(parentOf(node));
                }
                // 2.12、叔叔节点空或黑
                else {
                    if (rightOf(parentOf(node)) == node) {
                        node = parentOf(node);
                        leftRotated(node);
                    }
                    setColor(parentOf(node), BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    // 父节点为左孩子，右旋
                    rightRotated(parentOf(parentOf(node)));
                }
            }
            // 2.2、节点的父节点为爷爷节点的右孩子(左节点情况中，左转右)
            else {
                RBNode<K, V> y = leftOf(parentOf(parentOf(node)));
                // 2.21、叔叔节点为红色
                if (colorOf(y) == RED) {
                    // 父节点设黑
                    setColor(parentOf(node), BLACK);
                    // 叔叔节点设黑
                    setColor(y, BLACK);
                    // 祖父节点设红
                    setColor(parentOf(parentOf(node)), RED);
                    // 递归向上处理
                    node = parentOf(parentOf(node));
                }
                // 2.22、叔叔节点空或黑
                else {
                    if (leftOf(parentOf(node)) == node) {
                        node = parentOf(node);
                        rightRotated(node);
                    }
                    setColor(parentOf(node), BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    // 父节点为左孩子，右旋
                    rightRotated(parentOf(parentOf(node)));
                }
            }
        }
        // 根节点染黑
        setColor(root, BLACK);
    }

    private RBNode<K, V> parentOf(RBNode<K, V> node) {
        return node == null ? null : node.parent;
    }

    private RBNode<K, V> rightOf(RBNode<K, V> node) {
        return node == null ? null : node.right;
    }

    private RBNode<K, V> leftOf(RBNode<K, V> node) {
        return node == null ? null : node.left;
    }

    private boolean colorOf(RBNode<K, V> node) {
        // 判断时增加节点为叶子节点情况
        return node == null ? BLACK : node.color;
    }

    private RBNode<K, V> setColor(RBNode<K, V> node, boolean color) {
        node.color = color;
        return node;
    }

    // 前驱节点
    private RBNode<K, V> predecessor(RBNode<K, V> node) {
        if (node.left != null) {
            RBNode<K, V> p = node.left;
            while (p.right != null) {
                p = p.right;
            }
            return p;
        } else {
            RBNode<K, V> p = node.parent;
            while (p.parent.right == p) {
                p = p.parent;
            }
            return p;
        }
    }

    // 后继节点
    private RBNode<K, V> secessor(RBNode<K, V> node) {
        if (node.right != null) {
            RBNode<K, V> p = node.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            RBNode<K, V> p = node.parent;
            while (p.parent.left == p) {
                p = p.parent;
            }
            return p;
        }
    }

    static class RBNode<K extends Comparable<K>, V> {
        private K key;
        private V value;
        private boolean color;
        private RBNode<K, V> parent;
        private RBNode<K, V> left;
        private RBNode<K, V> right;

        public RBNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
