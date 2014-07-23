/*******************************************************************************
 * Copyright (c) 2011, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.orion.server.core;

/**
 * Public constants available to clients of the orion server core API.
 */
public class ServerConstants {

	/**
	 * The system property name for the secure storage master password.
	 */
	public static final String CONFIG_AUTH_ADMIN_DEFAULT_PASSWORD = "orion.auth.admin.default.password"; //$NON-NLS-1$

	/**
	 * The name of the configuration property that tells us what server to use for authentication purposes.
	 * In a basic server configuration this will be undefined, and the direct Orion server will be treated as
	 * the authentication host. If the Orion server is sitting behind a proxy, the server administrator
	 * will typically need to set the value of this property to be the proxy host. Refer to the Orion
	 * server administration guide for more details.
	 */
	public static final String CONFIG_AUTH_HOST = "orion.auth.host"; //$NON-NLS-1$

	/**
	 * The name of a configuration property specifying the name of the authorization
	 * component to be used.
	 */
	public static final String CONFIG_AUTH_NAME = "orion.auth.name"; //$NON-NLS-1$

	/**
	 * The API used for verifying Persona logins.
	 */
	public static final String CONFIG_AUTH_PERSONA_VERIFIER = "orion.auth.persona.verifier"; //$NON-NLS-1$

	/**
	 * The name of a configuration property specifying an alternate URI to handle registrations for accounts.
	 * If this variable is set AND the site does not allow for direct registrations the
	 * Register Button will be visible and this URI will be opened taking the user off site.
	 */
	public static final String CONFIG_AUTH_REGISTRATION_URI = "orion.auth.registration.uri"; //$NON-NLS-1$

	/**
	 * The name of a configuration property specifying a comma-separated list of users
	 * that are allowed to create accounts. If unspecified, then anonymous users can
	 * create accounts.
	 */
	public static final String CONFIG_AUTH_USER_CREATION = "orion.auth.user.creation"; //$NON-NLS-1$

	/**
	 * The name of a configuration property specifying is user email is mandatory while user creation.
	 * If <code>true</code> user will be forced to add email while creating account. Account will be blocked
	 * until user email is confirmed.
	 */
	public static final String CONFIG_AUTH_USER_CREATION_FORCE_EMAIL = "orion.auth.user.creation.force.email"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying the uri for the reverse proxy for the docker websocket.
	 */
	public static final String CONFIG_DOCKER_PROXY_URI = "orion.core.docker.proxy.uri"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying the uri for the docker server for the docker remote API.
	 */
	public static final String CONFIG_DOCKER_URI = "orion.core.docker.uri"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying the start of the port range for the docker server to use for port mapping the docker remote API.
	 */
	public static final String CONFIG_DOCKER_PORT_START = "orion.core.docker.port.start"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying the end of the port range for the docker server to use for port mapping the docker remote API.
	 */
	public static final String CONFIG_DOCKER_PORT_END = "orion.core.docker.port.end"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying the UID of the process running the orion server, default is 1000
	 */
	public static final String CONFIG_DOCKER_UID = "orion.core.docker.uid"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying the GID of the process running the orion server, default is 100
	 */
	public static final String CONFIG_DOCKER_GID = "orion.core.docker.gid"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying the username for the MQTT message broker
	 */
	public static final String CONFIG_EVENT_USERNAME = "orion.events.username"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying the password for the MQTT message broker
	 */
	public static final String CONFIG_EVENT_PASSWORD = "orion.events.password"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying the URI for the MQTT message broker
	 */
	public static final String CONFIG_EVENT_HOST = "orion.events.uri"; //$NON-NLS-1$
	
	/**
	 * The name of a configuration property specifying a comma-separated list of server
	 * file system paths where user content can be written. By default user content
	 * can only appear within the server instance location (workspace).
	 */
	public static final String CONFIG_FILE_ALLOWED_PATHS = "orion.file.allowedPaths"; //$NON-NLS-1$

	/**
	 * The name of a configuration property specifying whether anonymous read access
	 * is allowed to files stored on this orion server. The property value is a boolean and
	 * the default is <code>false</code>.
	 */
	public static final String CONFIG_FILE_ANONYMOUS_READ = "orion.file.anonymous.read"; //$NON-NLS-1$

	/**
	 * The name of a configuration property specifying the default source configuration management
	 * system to use for newly created top level folders.
	 */
	public static final String CONFIG_FILE_DEFAULT_SCM = "orion.file.defaultSCM"; //$NON-NLS-1$

	/**
	 * The name of a configuration property specifying the layout format for user data files.
	 */
	public static final String CONFIG_FILE_LAYOUT = "orion.file.layout"; //$NON-NLS-1$

	/**
	 * The name of a configuration property specifying a flat layout format for user data files.
	 */
	public static final String CONFIG_FILE_LAYOUT_FLAT = "flat"; //$NON-NLS-1$

	/**
	 * The name of a configuration property specifying that user data files are organized in a 
	 * hierarchy by the user who created it.
	 */
	public static final String CONFIG_FILE_LAYOUT_USERTREE = "usertree"; //$NON-NLS-1$
	/**
	 * The name of configuration property specifying the SMTP host for sending mail
	 */
	public static final String CONFIG_MAIL_SMTP_HOST = "mail.smtp.host"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying if TLS should be enabled
	 */
	public static final String CONFIG_MAIL_SMTP_STARTTLS = "mail.smtp.starttls.enable"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying which meta store should be enabled
	 */
	public static final String CONFIG_META_STORE = "orion.core.metastore"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying the legacy meta store
	 */
	public static final String CONFIG_META_STORE_LEGACY = "legacy"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying the simple meta store
	 */
	public static final String CONFIG_META_STORE_SIMPLE = "simple"; //$NON-NLS-1$

	/**
	 * The name of configuration property specifying the second version of the simple meta store
	 */
	public static final String CONFIG_META_STORE_SIMPLE_V2 = "simple2"; //$NON-NLS-1$

	/**
	 * name of configuration property for the disk usage calculation support.
	 * When this property is set to true, the disk usage calculation support is enabled.
	 */
	public static final String CONFIG_DISK_USAGE_ENABLED = "orion.file.diskUsageEnabled"; //$NON-NLS-1$

	/**
	 * The name of a configuration property specifying the virtual hosts to use for
	 * test sites launched by this server. The property value is a comma-separated 
	 * list of host names.
	 */
	public static final String CONFIG_SITE_VIRTUAL_HOSTS = "orion.site.virtualHosts"; //$NON-NLS-1$
	
	/**
	 * The name of a configuration property specifying the context path to use
	 *  for the server (e.g. /code).
	 */
	public static final String CONFIG_CONTEXT_PATH = "orion.context.path";

	/**
	 * The bundle ID of the server core. 
	 */
	public static final String PI_SERVER_CORE = "org.eclipse.orion.server.core"; //$NON-NLS-1$
	/**
	 * The preference qualifier for server configuration preferences.
	 */
	public static final String PREFERENCE_SCOPE = "org.eclipse.orion.server.configurator"; //$NON-NLS-1$

	/**
	 * The system property name for the location of the server configuration file.
	 * When this property is not set, the default is a file called "orion.conf" in the
	 * current working directory of the server process.
	 */
	public static final String PROP_CONFIG_FILE_LOCATION = "orion.core.configFile"; //$NON-NLS-1$
}
