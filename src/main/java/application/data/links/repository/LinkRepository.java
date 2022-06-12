package application.data.links.repository;

import application.data.links.Link;
import application.data.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link , Long> {
    @Query("SELECT link FROM Link link WHERE link.user=:user")
    List<Link> getLinksForUser(@Param("user") User user);
}
