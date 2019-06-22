package com.yl.datastructure.Tree;

import com.yl.common.ArrayException;

/**
 * 封装树中的方法
 * @version v1.1.0
 * @author yanglun
 * @date  2019/6/17 0:00
 * Modification History:
 *   Date           Author          Version            Description
 *-------------------------------------------------------------
 *    2019/6/17      yanglun            v1.0.0              修改原因
 */
public interface Tree {

    /**
     * @Function: com.yl.datastructure.Tree.Tree::find
     * @description 查找某个节点
     * @throws Exception
     * @version v1.1.0
     * @author yanglun
     * @date  2019/6/17 0:01
     * Modification History:
     *   Date           Author          Version            Description
     *-------------------------------------------------------------
     *    2019/6/17      yanglun            v1.0.0              修改原因
     */
    Node find(int data) throws ArrayException;

    /**
     * @Function: com.yl.datastructure.Tree.Tree::
     * @description 插入指定节点
     * @version v1.1.0
     * @author yanglun
     * @date  2019/6/17 0:02
     * Modification History:
     *   Date           Author          Version            Description
     *-------------------------------------------------------------
     *    2019/6/17      yanglun            v1.0.0              修改原因
     */
    boolean insert(int data) throws ArrayException;

    /**
     * @Function: com.yl.datastructure.Tree.Tree::delete
     * @description 删除指定节点
     * @throws Exception
     * @version v1.1.0
     * @author yanglun
     * @date  2019/6/17 0:05
     * Modification History:
     *   Date           Author          Version            Description
     *-------------------------------------------------------------
     *    2019/6/17      yanglun            v1.0.0              修改原因
     */
    boolean delete(int data) throws ArrayException;

    /**
     * @Function: com.yl.datastructure.Tree.Tree::infixOrder
     * @description  中序遍历
     *      左子树 -> 根节点 -> 右子树
     * @throws Exception
     * @version v1.1.0
     * @author yanglun
     * @date  2019/6/23 0:12
     * Modification History:
     *   Date           Author          Version            Description
     *-------------------------------------------------------------
     *    2019/6/23      yanglun            v1.0.0              修改原因
     */
    void infixOrder(Node currentNode) throws Exception;

    /**
     * @Function: com.yl.datastructure.Tree.Tree::preOrder
     * @description 前序遍历
     *      根节点 -> 左子树 -> 右子树
     * @throws Exception
     * @version v1.1.0
     * @author yanglun
     * @date  2019/6/23 0:14
     * Modification History:
     *   Date           Author          Version            Description
     *-------------------------------------------------------------
     *    2019/6/23      yanglun            v1.0.0              修改原因
     */
    void preOrder(Node currentNode) throws Exception;

    /**
     * @Function: com.yl.datastructure.Tree.Tree::postOrder
     * @description 后续遍历
     *       左子树 -> 右子树 -> 根节点
     * @throws Exception
     * @version v1.1.0
     * @author yanglun
     * @date  2019/6/23 0:16
     * Modification History:
     *   Date           Author          Version            Description
     *-------------------------------------------------------------
     *    2019/6/23      yanglun            v1.0.0              修改原因
     */
    void postOrder(Node currentNode) throws Exception;
}
