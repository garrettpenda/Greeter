package org.jboss.as.quickstarts.greeter.web;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.as.quickstarts.greeter.domain.User;
import org.jboss.as.quickstarts.greeter.domain.UserDao;

@Named
@RequestScoped
public class RemoveController {
	
	@Inject
    private FacesContext facesContext;

    @Inject
    private UserDao userDao;

    @Named
    @Produces
    @RequestScoped
    private User delUser = new User();

    public void remove() {
        try {
            userDao.delUsername(delUser.getUsername() );
            String message = "A user with username " + delUser.getUsername() + " has been removed successfully";
            facesContext.addMessage(null, new FacesMessage(message));
        } catch (Exception e) {
            String message = "An error has occured while removing the user (see log for details)";
            facesContext.addMessage(null, new FacesMessage(message));
        }
    }

}
