package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ReleaseGroupPrimaryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseGroupPrimaryTypeRepository extends JpaRepository<ReleaseGroupPrimaryType,Long>{
}
