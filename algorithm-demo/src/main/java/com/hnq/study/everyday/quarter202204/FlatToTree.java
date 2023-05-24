package com.hnq.study.everyday.quarter202204;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author henengqiang
 * @date 2022/11/25
 */
public class FlatToTree {

    public static void main(String[] args) {
        List<Dept> deptList = init();
        List<Dept> tree = flatToTree(deptList, 0);
        System.out.println(tree);
    }

    private static List<Dept> flatToTree(List<Dept> deptList, Integer pid) {
        List<Dept> result = Lists.newArrayList();
        for (Dept dept : deptList) {
            if (Objects.equals(pid, dept.getPid())) {
                List<Integer> exist = result.stream().map(Dept::getId).collect(Collectors.toList());
                exist.add(dept.getId());
                List<Dept> toDeep = deptList.stream().filter(d -> !exist.contains(d.getId())).collect(Collectors.toList());
                toDeep.remove(dept);
                dept.setChildren(flatToTree(toDeep, dept.getId()));
                result.add(dept);
            }
        }
        return result;
    }

    private static List<Dept> init() {
        return Lists.newArrayList(
                new Dept(1, "部门1", 0),
                new Dept(2, "部门2", 1),
                new Dept(3, "部门3", 1),
                new Dept(4, "部门4", 3),
                new Dept(5, "部门5", 4)
        );
    }


    private static class Dept {
        private Integer id;
        private String name;
        private Integer pid;
        private List<Dept> children;

        public Dept(Integer id, String name, Integer pid) {
            this.id = id;
            this.name = name;
            this.pid = pid;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPid() {
            return pid;
        }

        public void setPid(Integer pid) {
            this.pid = pid;
        }

        public List<Dept> getChildren() {
            return children;
        }

        public void setChildren(List<Dept> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return String.format("{\"id\":%d, \"name\":\"%s\", \"pid\":%d, \"children\":%s}", id, name, pid, children);
        }
    }
}
