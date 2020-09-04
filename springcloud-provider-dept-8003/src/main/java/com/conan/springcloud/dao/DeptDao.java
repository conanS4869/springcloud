package com.conan.springcloud.dao;

import com.conan.springcloud.pojo.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface DeptDao {
    boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
