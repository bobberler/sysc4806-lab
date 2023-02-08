package tom.lumsden.lab3;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(String name);
    BuddyInfo findById(long id);

}
