package ducnh.springboot.repository;

import java.util.List;

import ducnh.springboot.dto.RoleDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ducnh.springboot.model.entity.RoleEntity;
import ducnh.springboot.projection.IRoleCount;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	Slice<RoleEntity> findByNameContaining(String name,Pageable pageable);

	@Query(value = "SELECT r.name AS roleName,COUNT(u.id) AS count FROM role AS r, user AS u, user_role AS ur WHERE r.id = ur.role_id AND u.id = ur.user_id GROUP BY r.name ", nativeQuery = true)
	public List<IRoleCount> RoleCountEm();
}
