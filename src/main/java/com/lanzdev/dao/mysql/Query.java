package com.lanzdev.dao.mysql;

/**
 * Contains necessary queries for data base
 */
public final class Query {

    /**
     * Class cannot be instantiated
     */
    private Query( ) {
    }

    /*
     * Queries for antonyms
     */
    public static final String INSERT_ANTONYM = "INSERT INTO antonym (antonym, term_id) VALUES (?, ?)";
    public static final String SELECT_LAST_ANTONYM = "SELECT * FROM antonym WHERE antonym_id = last_insert_id()";
    public static final String SELECT_ANTONYM_BY_ID = "SELECT * FROM antonym WHERE antonym_id = ?";
    public static final String SELECT_ANTONYMS_BY_TERM_ID = "SELECT * FROM antonym WHERE term_id = ?";
    public static final String SELECT_ALL_ANTONYMS = "SELECT * FROM antonym";
    public static final String UPDATE_ANTONYM = "UPDATE antonym SET antonym = ?, term_id = ? WHERE antonym_id = ?";
    public static final String DELETE_ANTONYM = "DELETE FROM antonym WHERE antonym_id = ?";

    /*
     * Queries for definitions
     */
    public static final String INSERT_DEFINITION = "INSERT INTO definition (definition, term_id) VALUES (?, ?)";
    public static final String SELECT_LAST_DEFINITION = "SELECT * FROM definition WHERE definition_id = last_insert_id()";
    public static final String SELECT_DEFINITION_BY_ID = "SELECT * FROM definition WHERE definition_id = ?";
    public static final String SELECT_DEFINITION_BY_TERM_ID = "SELECT * FROM definition WHERE term_id = ?";
    public static final String SELECT_ALL_DEFINITIONS = "SELECT * FROM definition";
    public static final String UPDATE_DEFINITION = "UPDATE definition SET definition = ?, term_id = ? WHERE definition_id = ?";
    public static final String DELETE_DEFINITION = "DELETE FROM definition WHERE definition_id = ?";

    /*
     * Queries for permissions
     */
    public static final String INSERT_PERMISSION = "INSERT INTO permission (permission) VALUES (?)";
    public static final String SELECT_LAST_PERMISSION = "SELECT * FROM permission WHERE permission_id = last_insert_id()";
    public static final String SELECT_PERMISSION_BY_ID = "SELECT * FROM permission WHERE permission_id = ?";
    public static final String SELECT_ALL_PERMISSIONS = "SELECT * FROM permission";
    public static final String UPDATE_PERMISSION = "UPDATE permission SET permission = ? WHERE permission_id = ?";
    public static final String DELETE_PERMISSION = "DELETE FROM permission WHERE permission_id = ?";

    /*
     * Queries for roles
     */
    public static final String INSERT_ROLE = "INSERT INTO role (role) VALUES (?)";
    public static final String SELECT_LAST_ROLE = "SELECT * FROM role WHERE role_id = last_insert_id()";
    public static final String SELECT_ROLE_BY_ID = "SELECT * FROM role WHERE role_id = ?";
    public static final String SELECT_ALL_ROLES = "SELECT * FROM role";
    public static final String UPDATE_ROLE = "UPDATE role SET role = ? WHERE role_id = ?";
    public static final String DELETE_ROLE = "DELETE FROM role WHERE role_id = ?";

    /*
     * Queries for role permissions
     */
    public static final String INSERT_ROLE_PERMISSIONS = "INSERT INTO role_permissions (role_id, permission_id) VALUES (?, ?)";
    public static final String SELECT_LAST_ROLE_PERMISSIONS = "SELECT * FROM role_permissions WHERE role_permissions_id = last_insert_id()";
    public static final String SELECT_ROLE_PERMISSION_BY_ID = "SELECT * FROM role_permissions WHERE rope_permissions_id = ?";
    public static final String SELECT_ALL_ROLE_PERMISSIONS = "SELECT * FROM role_permissions";
    public static final String UPDATE_ROLE_PERMISSIONS = "UPDATE role_permissions SET role_id = ?, permission_id = ? WHERE role_permissions_id = ?";
    public static final String DELETE_ROLE_PERMISSIONS = "DELETE FROM role_permissions WHERE role_permissions_id = ?";

    /*
     * Queries for suites
     */
    public static final String INSERT_SUITE = "INSERT INTO suite (created_by, privacy) VALUES (?, ?)";
    public static final String SELECT_LAST_SUITE = "SELECT * FROM suite WHERE suite_id = last_insert_id()";
    public static final String SELECT_SUITE_BY_ID = "SELECT * FROM suite WHERE suite_id = ?";
    public static final String SELECT_ALL_SUITES = "SELECT * FROM suite";
    public static final String UPDATE_SUITE = "UPDATE suite SET created_by = ?, privacy = ? WHERE suite_id = ?";
    public static final String DELETE_SUITE = "DELETE FROM suite WHERE suite_id = ?";

    /*
     * Queries for synonyms
     */
    public static final String INSERT_SYNONYM = "INSERT INTO synonym (synonym, term_id) VALUES (?, ?)";
    public static final String SELECT_LAST_SYNONYM = "SELECT * FROM synonym WHERE synonym_id = last_insert_id()";
    public static final String SELECT_SYNONYM_BY_ID = "SELECT * FROM synonym WHERE synonym_id = ?";
    public static final String SELECT_SYNONYM_BY_TERM_ID = "SELECT * FROM synonym WHERE term_id = ?";
    public static final String SELECT_ALL_SYNONYMS = "SELECT * FROM synonym";
    public static final String UPDATE_SYNONYM = "UPDATE synonym SET synonym = ?, term_id = ? WHERE synonym_id = ?";
    public static final String DELETE_SYNONYM = "DELETE FROM synonym WHERE synonym_id = ?";

    /*
     * Queries for terms
     */
    public static final String INSERT_TERM = "INSERT INTO term (origin) VALUES (?)";
    public static final String SELECT_LAST_TERM = "SELECT * FROM term WHERE term_id = last_insert_id()";
    public static final String SELECT_TERM_BY_ID = "SELECT * FROM term WHERE term_id = ?";
    public static final String SELECT_ALL_TERMS = "SELECT * FROM term";
    public static final String UPDATE_TERM = "UPDATE term SET origin = ? WHERE term_id = ?";
    public static final String DELETE_TERM = "DELETE FROM term WHERE term_id = ?";

    /*
     * Queries for term suites
     */
    public static final String INSERT_TERM_SUITES = "INSERT INTO term_suites (term_id, suite_id) VALUES (?, ?)";
    public static final String SELECT_LAST_TERM_SUITES = "SELECT * FROM term_suites WHERE term_suites_id = last_insert_id()";
    public static final String SELECT_TERM_SUITES_BY_ID = "SELECT * FROM term_suites WHERE term_suites_id = ?";
    public static final String SELECT_ALL_TERM_SUITES = "SELECT * FROM term_suites";
    public static final String UPDATE_TERM_SUITES = "UPDATE term_suites SET term_id = ?, suite_id = ? WHERE term_suites_id = ?";
    public static final String DELETE_TERM_SUITES = "DELETE FROM term_suites WHERE term_suites_id = ?";

    /*
     * Queries for users
     */
    public static final String INSERT_USER = "INSERT INTO user (login, password, email, date) VALUES (?, ?, ?, ?)";
    public static final String SELECT_LAST_USER = "SELECT * FROM user WHERE user_id = last_insert_id()";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE user_id = ?";
    public static final String SELECT_ALL_USERS = "SELECT * FROM user";
    public static final String UPDATE_USER = "UPDATE user SET login = ?, password = ?, email = ?, date = ? WHERE user_id = ?";
    public static final String DELETE_USER = "DELETE FROM user WHERE user_id = ?";

    /*
     * Queries for user roles
     */
    public static final String INSERT_USER_ROLES = "INSERT INTO user_roles (user_id, role_id) VALUES (?, ?)";
    public static final String SELECT_LAST_USER_ROLES = "SELECT * FROM user_roles WHERE user_roles_id = last_insert_id()";
    public static final String SELECT_USER_ROLES_BY_ID = "SELECT * FROM user_roles WHERE user_roles_id = ?";
    public static final String SELECT_ALL_USER_ROLES = "SELECT * FROM user_roles";
    public static final String UPDATE_USER_ROLES = "UPDATE user_roles SET user_id = ?, role_id = ? WHERE user_roles_id = ?";
    public static final String DELETE_USER_ROLES = "DELETE FROM user_roles WHERE user_roles_id = ?";

}
