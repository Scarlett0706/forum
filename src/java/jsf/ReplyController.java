package jsf;

import entity.Reply;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import session.ReplyFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

@Named("replyController")
@SessionScoped
public class ReplyController implements Serializable {

    private Reply current;
    private DataModel items = null;
    @EJB
    private session.ReplyFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private String PostId,PeopleId;
    private List<Reply> ReplySearchResults,ReplySearchResults_;

    public ReplyController() {
    }
    
     public void findPostByPostId(){
         
    try{
        this.ReplySearchResults=(List<Reply>)ejbFacade.locateReplyByPostId(PostId);
    }
    catch(Exception e){
        
    }
    }
     
     public void findPostByPeopleId(){
         
    try{
        this.ReplySearchResults_=(List<Reply>)ejbFacade.locateReplyByPeopleId(PeopleId);
    }
    catch(Exception e){
        
    }
    }
     
     public List<Reply> getReplySearchResults_(){
     return this.ReplySearchResults_;
     }

     public void setReplySearchResults_(){
         this.ReplySearchResults_=ReplySearchResults_;
     }
     
     public String getPeopleId(){
         return this.PeopleId;
     }
     
     public void setPeopleId(String PeopleId){
         this.PeopleId=PeopleId;
     }
     
public List<Reply> getReplySearchResults(){
    return this.ReplySearchResults;
}     

public void setReplySearchResults(List<Reply> ReplySearchResults){
    this.ReplySearchResults=ReplySearchResults;
}
     public String getPostId(){
         return this.PostId;
     }
     
     public void setPostId(String PostId){
         this.PostId=PostId;
     }
     
    public Reply getSelected() {
        if (current == null) {
            current = new Reply();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ReplyFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "reply/List";
    }

    public String prepareView() {
        current = (Reply) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "reply/View";
    }

    public String prepareCreate() {
        current = new Reply();
        selectedItemIndex = -1;
        return "reply/Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ReplyCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Reply) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "reply/Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ReplyUpdated"));
            return "reply/View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Reply) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "reply/List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "reply/View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "reply/List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ReplyDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "Reply/List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "Reply/List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Reply getReply(java.lang.String id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Reply.class)
    public static class ReplyControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ReplyController controller = (ReplyController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "replyController");
            return controller.getReply(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Reply) {
                Reply o = (Reply) object;
                return getStringKey(o.getIdReply());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Reply.class.getName());
            }
        }

    }

}
