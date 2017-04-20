package com.lanzdev;

public final class Path {

    private Path() {}

    public static final String WELCOME_PAGE = "index.jsp";

    /*
     * Antonym
     */
    public static final String FORWARD_TO_VIEW_ANTONYM_LIST = "/WEB-INF/jsp/listAntonym.jsp";
    public static final String FORWARD_TO_ADD_ANTONYM_FORM = "/WEB-INF/jsp/addAntonymForm.jsp";

    public static final String REDIRECT_TO_VIEW_ANTONYM_LIST = "controller?command=ListAntonym";
    public static final String REDIRECT_TO_VIEW_ADD_ANTONYM_FORM = "controller?command=AddAntonym";

    /*
     * Definition
     */
    public static final String FORWARD_TO_VIEW_DEFINITION_LIST = "/WEB-INF/jsp/listDefinition.jsp";
    public static final String FORWARD_TO_ADD_DEFINITION_FORM = "/WEB-INF/jsp/addDefinitionForm.jsp";

    public static final String REDIRECT_TO_VIEW_DEFINITION_LIST = "controller?command=ListDefinition";
    public static final String REDIRECT_TO_VIEW_ADD_DEFINITION_FORM = "controller?command=AddDefinition";

    /*
     * Permission
     */
    public static final String FORWARD_TO_VIEW_PERMISSION_LIST = "/WEB_INF/jsp/listPermission.jsp";
    public static final String FORWARD_TO_ADD_PERMISSION_FORM = "/WEB-INF/jsp.addPermissionForm.jsp";

    public static final String REDIRECT_TO_VIEW_PERMISSION_LIST = "controller?command=ListPermission";
    public static final String REDIRECT_TO_VIEW_ADD_PERMISSION_FORM = "controller?command=AddPermission";

    /*
     * Role
     */
    public static final String FORWARD_TO_VIEW_ROLE_LIST = "/WEB-INF/jsp/listRole.jsp";
    public static final String FORWARD_TO_ADD_ROLE_FORM = "/WEB-INF/jsp/addRoleForm.jsp";

    public static final String REDIRECT_TO_VIEW_ROLE_LIST = "controller?command=ListRole";
    public static final String REDIRECT_TO_VIEW_ADD_ROLE_FORM = "controller?command=AddRole";

    /*
     * Role permissions
     */
    public static final String FORWARD_TO_VIEW_ROLE_PERMISSIONS_LIST = "/WEB-INF/jsp/listRolePermissions.jsp";
    public static final String FORWARD_TO_ADD_ROLE_PERMISSIONS_FORM = "/WEB-INF/jsp/addRolePermissionsForm.jsp";

    public static final String REDIRECT_TO_VIEW_ROLE_PERMISSIONS_LIST = "controller?command=ListRolePermissions";
    public static final String REDIRECT_TO_VIEW_ADD_ROLE_PERMISSIONS_FORM = "controller?command=AddRolePermissions";

    /*
     * Suite
     */
    public static final String FORWARD_TO_VIEW_SUITE_LIST = "/WEB-INF/jsp/listSuite.jsp";
    public static final String FORWARD_TO_ADD_SUITE_FORM = "/WEB-INF/jsp/addSuiteForm.jsp";

    public static final String REDIRECT_TO_VIEW_SUITE_LIST = "controller?command=ListSuite";
    public static final String REDIRECT_TO_VIEW_ADD_SUITE_FORM = "controller?command=AddSuite";

    /*
     * Synonym
     */
    public static final String FORWARD_TO_VIEW_SYNONYM_LIST = "/WEB-INF/jsp/listSynonym.jsp";
    public static final String FORWARD_TO_ADD_SYNONYM_FORM = "/WEB-INF/jsp/addSynonymForm.jsp";

    public static final String REDIRECT_TO_VIEW_SYNONYM_LIST = "controller?command=ListSynonym";
    public static final String REDIRECT_TO_VIEW_ADD_SYNONYM_FORM = "controller?command=AddSynonym";

    /*
     * Term
     */
    public static final String FORWARD_TO_VIEW_TERM_LIST = "/WEB-INF/jsp/listTerm.jsp";
    public static final String FORWARD_TO_ADD_TERM_FORM = "/WEB-INF/jsp/addTermForm.jsp";

    public static final String REDIRECT_TO_VIEW_TERM_LIST = "controller?command=ListTerm";
    public static final String REDIRECT_TO_VIEW_ADD_TERM_FORM = "controller?command=AddTerm";

    /*
     * Term suites
     */
    public static final String FORWARD_TO_VIEW_TERM_SUITES_LIST = "/WEB-INF/jsp/listTermSuites.jsp";
    public static final String FORWARD_TO_ADD_TERM_SUITES_FORM = "/WEB-INF/jsp/addTermSuitesForm.jsp";

    public static final String REDIRECT_TO_VIEW_TERM_SUITES_LIST = "controller?command=ListTermSuites";
    public static final String REDIRECT_TO_VIEW_ADD_TERM_SUITES_FORM = "controller?command=AddTermSuites";

    /*
     * User
     */
    public static final String FORWARD_TO_VIEW_USER_LIST = "/WEB-INF/jsp/listUser.jsp";
    public static final String FORWARD_TO_ADD_USER_FORM = "/WEB-INF/jsp/addUserForm.jsp";

    public static final String REDIRECT_TO_VIEW_USER_LIST = "controller?command=ListUser";
    public static final String REDIRECT_TO_VIEW_ADD_USER_FORM = "controller?command=AddUser";

    /*
     * User roles
     */
    public static final String FORWARD_TO_VIEW_USER_ROLES_LIST = "/WEB-INF/jsp/listUserRoles.jsp";
    public static final String FORWARD_TO_ADD_USER_ROLES_FORM = "/WEB-INF/jsp/addUserRolesForm.jsp";

    public static final String REDIRECT_TO_VIEW_USER_ROLES_LIST = "controller?command=ListUserRoles";
    public static final String REDIRECT_TO_VIEW_ADD_USER_ROLES_FORM = "controller?command=AddUserRoles";


}
