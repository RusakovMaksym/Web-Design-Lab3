package application.data.links.service;

import application.data.links.Link;
import application.data.links.repository.LinkRepositoryImplementation;
import application.data.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {
    private LinkRepositoryImplementation linkRepository;

    @Autowired
    public void setLinkRepository(LinkRepositoryImplementation linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> getLinks(User user) {
        return linkRepository.getLinks(user);
    }

    public void addLink(Link link) {
        linkRepository.addLink(link);
    }
}
