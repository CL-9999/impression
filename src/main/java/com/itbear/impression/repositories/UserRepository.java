package com.itbear.impression.repositories;

import com.itbear.impression.entities.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author：Bear
 * @site：https://www.yuque.com/itbear
 * @email：bearpess@gmail.com
 * @created 2021-08-08 23:10:35 星期日
 * <p>
 * features：
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
