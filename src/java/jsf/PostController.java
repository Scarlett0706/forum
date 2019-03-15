package jsf;

import entity.Post;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import session.PostFacade;

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
import jsf.PeopleController;

@Named("postController")
@SessionScoped
public class PostController implements Serializable {

    private Post current;
    private DataModel items = null;
    @EJB
    private session.PostFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private List<Post> PostSearchResults,PostSearchResults_;
    private List<Post> PostSearchResults1,PostSearchResults2,PostSearchResults3,PostSearchResults4,PostSearchResults5,PostSearchResults6,PostSearchResults7,PostSearchResults8,PostSearchResults9,PostSearchResults10,PostSearchResults11,PostSearchResults12,PostSearchResults13;
    private String Like;
    private String Type;
    private String PeopleId;

    public PostController() {
    }
    
    public void findPostByLike(){
         
    try{
        this.PostSearchResults=(List<Post>)ejbFacade.locatePostByLike(Like);
    }
    catch(Exception e){
        
    }
    }
    
    public void findPostByPeopleId(){
        try{
          this.PostSearchResults_=(List<Post>)ejbFacade.locatePostByPeopleId(PeopleId);
        }
        catch(Exception e){
            
        }
    }
    
    public void findPostByType1(){
        try{
        this.PostSearchResults1=(List<Post>)ejbFacade.locatePostByType("人文生活");
       }
    catch(Exception e){
        
    }
    }
    
    public void findPostByType2(){
        try{
        this.PostSearchResults2=(List<Post>)ejbFacade.locatePostByType("科技生活");
       }
    catch(Exception e){
        
    }
    }
    
    public void findPostByType3(){
        try{
        this.PostSearchResults3=(List<Post>)ejbFacade.locatePostByType("情感生活");
       }
    catch(Exception e){
        
    }
    }
    
    public void findPostByType4(){
        try{
        this.PostSearchResults4=(List<Post>)ejbFacade.locatePostByType("健康");
       }
    catch(Exception e){
        
    }
    }
    
    public void findPostByType5(){
        try{
        this.PostSearchResults5=(List<Post>)ejbFacade.locatePostByType("学习");
       }
    catch(Exception e){
        
    }
    }
    
    
    public void findPostByType6(){
        try{
        this.PostSearchResults6=(List<Post>)ejbFacade.locatePostByType("实习");
       }
    catch(Exception e){
        
    }
    }
    
    public void findPostByType7(){
        try{
        this.PostSearchResults7=(List<Post>)ejbFacade.locatePostByType("美食");
       }
    catch(Exception e){
        
    }
    }
    
    public void findPostByType8(){
        try{
        this.PostSearchResults8=(List<Post>)ejbFacade.locatePostByType("体育健身");
       }
    catch(Exception e){
        
    }
    }
    
    public void findPostByType9(){
        try{
        this.PostSearchResults9=(List<Post>)ejbFacade.locatePostByType("乡亲乡爱");
       }
    catch(Exception e){
        
    }
    }
    
    public void findPostByType10(){
        try{
        this.PostSearchResults10=(List<Post>)ejbFacade.locatePostByType("游戏对战");
       }
    catch(Exception e){
        
    }
    }
    
    public void findPostByType11(){
        try{
        this.PostSearchResults11=(List<Post>)ejbFacade.locatePostByType("人文艺术");
       }
    catch(Exception e){
        
    }
    }
    
    public void findPostByType12(){
        try{
        this.PostSearchResults12=(List<Post>)ejbFacade.locatePostByType("信息社会");
       }
    catch(Exception e){
        
    }
    }
    
    public void findPostByType13(){
        try{
        this.PostSearchResults13=(List<Post>)ejbFacade.locatePostByType("其他");
       }
    catch(Exception e){
        
    }
    }
    
     public String getPeopleId(){
        return this.PeopleId;
    }
   
    public void setPeopleId(String PeopleId){
        this.PeopleId=PeopleId;
    }
    
    public List<Post> getPostSearchResults_(){
        return this.PostSearchResults_;
    }
    
    public void setPostSearchResults_(List<Post> PostSearchResults_){
       
    }
    
    
    public List<Post> getPostSearchResults(){
        return this.PostSearchResults;
    }

    public void setPostSearchResults(List<Post> PostSearchResults){
        
    }
    
    public List<Post> getPostSearchResults1(){
        return this.PostSearchResults1;
    }

    public void setPostSearchResults1(List<Post> PostSearchResults1){
        
    }
    
    public List<Post> getPostSearchResults2(){
        return this.PostSearchResults2;
    }

    public void setPostSearchResults2(List<Post> PostSearchResults2){
        
    }
    
    public List<Post> getPostSearchResults3(){
        return this.PostSearchResults3;
    }

    public void setPostSearchResults3(List<Post> PostSearchResults3){
        
    }
    
    public List<Post> getPostSearchResults4(){
        return this.PostSearchResults4;
    }

    public void setPostSearchResults4(List<Post> PostSearchResults4){
        
    }
    
    public List<Post> getPostSearchResults5(){
        return this.PostSearchResults5;
    }

    public void setPostSearchResults5(List<Post> PostSearchResults5){
        
    }
    
    public List<Post> getPostSearchResults6(){
        return this.PostSearchResults6;
    }

    public void setPostSearchResults6(List<Post> PostSearchResults6){
        
    }
    
    public List<Post> getPostSearchResults7(){
        return this.PostSearchResults7;
    }

    public void setPostSearchResults7(List<Post> PostSearchResults7){
        
    }
    
    public List<Post> getPostSearchResults8(){
        return this.PostSearchResults8;
    }

    public void setPostSearchResults8(List<Post> PostSearchResults8){
        
    }
    
    public List<Post> getPostSearchResults9(){
        return this.PostSearchResults9;
    }

    public void setPostSearchResults9(List<Post> PostSearchResults9){
        
    }
    
    public List<Post> getPostSearchResults10(){
        return this.PostSearchResults10;
    }

    public void setPostSearchResults10(List<Post> PostSearchResults10){
        
    }
    
    public List<Post> getPostSearchResults11(){
        return this.PostSearchResults11;
    }

    public void setPostSearchResults11(List<Post> PostSearchResults11){
        
    }
    
    public List<Post> getPostSearchResults12(){
        return this.PostSearchResults12;
    }

    public void setPostSearchResults12(List<Post> PostSearchResults12){
        
    }
    
    public List<Post> getPostSearchResults13(){
        return this.PostSearchResults13;
    }

    public void setPostSearchResults13(List<Post> PostSearchResults13){
        
    }
    public void setLike(String Like){
        this.Like=Like;
    }
    
    public String getLike(){
        return Like;
    }
    
    public void setType(String Type){
        this.Type=Type;
    }
    
    public String getType(){
        return Type;
    }
    
    public Post getSelected() {
        if (current == null) {
            current = new Post();
            selectedItemIndex = -1;
        }
        return current;
    }

    private PostFacade getFacade() {
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
        return "post/List";
    }

    public String prepareView() {
        current = (Post) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "post/View";
    }

    public String prepareCreate() {
        current = new Post();
        selectedItemIndex = -1;
        return "post/Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PostCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Post) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "post/Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PostUpdated"));
            return "post/View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Post) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "post/List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "post/View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "post/List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PostDeleted"));
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
        return "post/List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "post/List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Post getPost(java.lang.String id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Post.class)
    public static class PostControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PostController controller = (PostController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "postController");
            return controller.getPost(getKey(value));
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
            if (object instanceof Post) {
                Post o = (Post) object;
                return getStringKey(o.getIdPost());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Post.class.getName());
            }
        }

    }

}
