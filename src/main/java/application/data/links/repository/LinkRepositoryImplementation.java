package application.data.links.repository;

import application.data.links.Link;
import application.data.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LinkRepositoryImplementation {
    private final LinkRepository linkRepository;

    @Autowired
    public LinkRepositoryImplementation(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> getLinks(User user) {
        return linkRepository.getLinksForUser(user);
    }

    public void addLink(Link link) {
        linkRepository.save(link);
    }
}
