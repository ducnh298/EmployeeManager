package ducnh.springboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import ducnh.springboot.dto.RoleDTO;
import ducnh.springboot.projection.IRoleCount;

@Service
public interface IRoleService {
	RoleDTO findById(Long id);

	RoleDTO save(RoleDTO role);

	List<IRoleCount> RoleCountEm();

	Slice<RoleDTO> findByNameContaining(String name, Pageable pageable);
}
