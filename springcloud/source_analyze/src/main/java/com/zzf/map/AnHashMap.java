package com.zzf.map;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * HashMap 源码分析
 * <p>
 * 数据结构----数组+链表，数组用来存储Key值的HASH值，链表用来存放节点
 * <p>
 * 数组和链表的对比（数组查询快，插入删除慢。链表插入删除快，查询慢。综合其特点，使用HashMap）
 *
 * @author zephyr
 */
public class AnHashMap<K, V> {

    /**
     * 数组默认的初始化大小，16位
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 数组最大长度，30位
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 负载因子，用于扩容
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;


    static final int TREEIFY_THRESHOLD = 8;

    static final int UNTREEIFY_THRESHOLD = 8;


    transient Node<K, V>[] table;

    transient Set<Map.Entry<K, V>> entrySet;

    transient int size;


    static class Node<K, V> implements Map.Entry<K, V> {

        //final只读
        final int hash;

        final K key;

        V value;

        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        //final修改
        @Override
        public final K getKey() {
            return null;
        }

        @Override
        public final V getValue() {
            return null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        /**
         * #TODO 这种写法
         *
         * @param newValue
         * @return
         */
        @Override
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue())) {
                    return true;
                }
            }
            return false;
        }
    }



    /*****************************   Map的几个功能   ******************************************/

    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    /**
     * put操作
     *
     * @param hash
     * @param key
     * @param value
     * @param onlyIfAbsent
     * @param evict
     * @return
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {

        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;
        if (((tab = table) == null || (n = tab.length) == 0)) {
            //数组未初始化为空，重新初始化
            n = (tab = resize()).length;
        }
        if ((p = tab[i = (n - 1) & hash]) == null) {
            //hash对应的位置为null的时候，直接插入节点
            tab[i] = newNode(hash, key, value, null);
        } else {
            Node<K, V> e;
            K k;
            if ((p.hash == hash) && ((k = p.key) == key || (key != null || key.equals(k)))) {
                //hash相等，key相等
                e = p;
            }
//            else if (p instanceof HashMap.T)

        }

        return value;


    }

    private Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
        return new Node<>(hash, key, value, next);
    }

    private Node<K, V>[] resize() {
        return null;
    }

    /**
     * Hash 方法，计算位置
     * <p>
     * Key的hashCode 与
     * 1111111111111111
     * 保留位为1的值 ^ 相同的保存，不同的为0
     *
     * @param key
     * @return
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


}
