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
    Node find(Object object) throws ArrayException;

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
    boolean insert(Object object) throws ArrayException;

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
    boolean delete(Object object);
}
