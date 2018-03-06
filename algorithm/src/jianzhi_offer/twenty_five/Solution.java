package jianzhi_offer.twenty_five;

//复杂链表的复制

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public RandomListNode Clone1(RandomListNode pHead) {
        cloneNodes(pHead);
        cloneSublingNodes(pHead);
        return connectNodes(pHead);
    }

    //复制next节点
    private void cloneNodes(RandomListNode pHead) {
        //保存pHead
        RandomListNode pNode = pHead;
        while (pNode != null) {
            //创建新节点
            RandomListNode pCloneNode = new RandomListNode(pNode.label);
            //将新节点添加到每个当前节点的后面，和原节点相同
            pCloneNode.next = pNode.next;
            pCloneNode.random = null;
            //pNode指向pCloneNode
            pNode.next = pCloneNode;
            //重新设置pNode
            pNode = pCloneNode.next;
        }
    }

    //复制random节点
    private void cloneSublingNodes(RandomListNode pHead) {
        //保存pHead
        RandomListNode pNode = pHead;
        while (pNode != null) {
            //复制的next节点
            RandomListNode pCloneNode = pNode.next;
            //pNode的random不为null，则pCloneNode的random在pNode的random之后
            if (pNode.random != null) {
                pCloneNode.random = pNode.random.next;
            }
            //重新设置pNode
            pNode = pCloneNode.next;
        }
    }

    //拆分成两个链表，奇数点位置构成原始链表，偶数点位置构成复制链表
    private RandomListNode connectNodes(RandomListNode pHead) {
        //保存pHead
        RandomListNode pNode = pHead;
        //返回pCloneHead，且保存
        RandomListNode pCloneHead = null;
        RandomListNode pCloneNode = null;
        //pHead不为null
        if (pNode != null) {
            //初始化
            pCloneHead = pNode.next;
            pCloneNode = pNode.next;
            //下一个pNode节点指向后面第二个节点，pNode.next=pNode.next.next
            pNode.next = pCloneNode.next;
            //pNode变为下一个pNode
            pNode = pNode.next;
        }
        while (pNode != null) {
            //上面pNode变成pNode.next后，pCloneNode.next在pNode之后
            pCloneNode.next = pNode.next;
            //更新下一个pCloneNode
            pCloneNode = pNode.next;
            //二者交替
            pNode.next = pCloneNode.next;
            //pNode变为下一个pNode
            pNode = pNode.next;
        }
        //返回pCloneHead
        return pCloneHead;
    }

    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode pCurNode = pHead;
        //复制链表next节点
        while (pCurNode != null) {
            RandomListNode pNode = new RandomListNode(pCurNode.label);
            pNode.next = pCurNode.next;
            pCurNode.next = pNode;
            //更新pCurNode
            pCurNode = pNode.next;
        }
        //复制链表random节点
        pCurNode = pHead;
        while (pCurNode != null) {
            RandomListNode pNode = pCurNode.next;
            if (pCurNode.random != null) {
                //复制链表的random节点在原始链表random节点的后面
                pNode.random = pCurNode.random.next;
            }
            pCurNode = pNode.next;
        }
        //返回复制链表
        pCurNode = pHead;
        RandomListNode pCloneNode = pHead.next;
        RandomListNode pNode = pCloneNode;
        //RandomListNode pNode=null;
        //while(pCurNode.next!=null){
        //pNode始终在pCurNode之后
        //pNode=pCurNode.next;
        //pCurNode.next=pNode.next;
        //分别拆分成两条链表
        //pCurNode=pNode;
        //}
        while (pCurNode != null) {
            //将pCurNode和pNode分别链接到下下一个节点
            pCurNode.next = pCurNode.next.next;
            if (pNode.next != null) {
                pNode.next = pNode.next.next;
            }
            //更新pCurNode和pNode
            pCurNode = pCurNode.next;
            pNode = pNode.next;
        }
        return pCloneNode;
    }
}
