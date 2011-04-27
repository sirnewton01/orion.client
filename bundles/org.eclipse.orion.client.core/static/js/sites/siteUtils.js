/*******************************************************************************
 * Copyright (c) 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 
 * (http://www.eclipse.org/legal/epl-v10.html), and the Eclipse Distribution 
 * License v1.0 (http://www.eclipse.org/org/documents/edl-v10.html). 
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/*global dojo eclipse:true */
/*jslint devel:true*/

dojo.getObject("eclipse.sites.util", true);

/**
 * @namespace Holds stateless utility methods for dealing with sites.
 */
eclipse.sites.util = {
	/**
	 * Returns a relative URL pointing to the editing page for the given site configuration. 
	 * @param {eclipse.sites.SiteConfiguration} site
	 * @return {String} The URL.
	 */
	generateEditSiteHref: function(site) {
		return "edit-site.html#" + eclipse.util.makeRelative(site.Location);
	},
	
	/**
	 * Parses the state of the edit-site page from a hash value.
	 * @param {String} hash The hash string.
	 * @returns {Object} An object having the properties:<ul>
	 * <li>{@link String} <code>site</code> The location URL of the site being edited.</li>
	 * <li>{@link String} <code>action</code> Optional, currently unused</li>
	 * <li>{@link String} <code>actionDetails</code> Optional, currently unused</li>
	 * </ul>
	 */
	parseStateFromHash: function(hash) {
		var obj = dojo.queryToObject(hash);
		var state = dojo.mixin({}, obj);
		// Find the property name that represents the site
		for (var prop in obj) {
			if (obj.hasOwnProperty(prop)) {
				if (obj[prop] === "" && prop !== "action" && prop !== "actionDetails") {
					state.site = prop;
					delete state[prop];
				}
			}
		}
		return state;
	},
	
	/**
	 * Converts the state of the edit-site page into a hash string.
	 * @param {String} siteLocation The location URL of the site configuration being edited.
	 * @param [String] action Currently unused
	 * @param [String] actionDetails Currently unused
	 * @returns {String} Hash string representing the new state.
	 */
	stateToHash: function(siteLocation, action, actionDetails) {
		var obj = {};
		if (siteLocation) {
			obj[siteLocation] = "";
		}
		if (action) {
			obj.action = action;
		}
		if (actionDetails) {
			obj.actionDetails = actionDetails;
		}
		return dojo.objectToQuery(obj);
	},
	
	/**
	 * Creates & adds commands that act on an individual site configuration.
	 * @param {eclipse.CommandService} commandService
	 * @param {eclipse.sites.SiteService} siteService
	 * @param {eclipse.StatusReportingService} statusService
	 * @param {eclipse.DialogService} dialogService
	 * @param {Function} startCallback
	 * @param {Function} stopCallback
	 * @param {Function} deleteCallback
	 * @param {Function} errorCallback Called when a server request fails.
	 */
	createSiteConfigurationCommands: function(commandService, siteService, statusService, dialogService,
			startCallback, stopCallback, deleteCallback, errorCallback) {
		var editCommand = new eclipse.Command({
			name: "Edit",
			image: "images/editing_16.gif",
			id: "eclipse.site.edit",
			visibleWhen: function(item) {
				return item.HostingStatus && item.HostingStatus.Status === "stopped";
			},
			hrefCallback: eclipse.sites.util.generateEditSiteHref});
		commandService.addCommand(editCommand, "object");
		
		var startCommand = new eclipse.Command({
			name: "Start",
			image: "images/lrun_obj.gif",
			id: "eclipse.site.start",
			visibleWhen: function(item) {
				return item.HostingStatus && item.HostingStatus.Status === "stopped";
			},
			callback: function(item) {
				statusService.setMessage("Starting...");
				// Just update the HostingStatus
				var newItem = {
					HostingStatus: {
						Status: "started"
					}
				};
				siteService.updateSiteConfiguration(item.Location, newItem).then(startCallback, errorCallback);
			}});
		commandService.addCommand(startCommand, "object");
		
		var stopCommand = new eclipse.Command({
			name: "Stop",
			image: "images/stop.gif",
			id: "eclipse.site.stop",
			visibleWhen: function(item) {
				return item.HostingStatus && item.HostingStatus.Status === "started";
			},
			callback: function(item) {
				statusService.setMessage("Stopping " + item.Name + "...");
				var newItem = {
					HostingStatus: {
						Status: "stopped"
					}
				};
				siteService.updateSiteConfiguration(item.Location, newItem).then(stopCallback, errorCallback);
			}});
		commandService.addCommand(stopCommand, "object");
		
		var deleteCommand = new eclipse.Command({
			name: "Delete",
			image: "images/remove.gif",
			id: "eclipse.site.delete",
			visibleWhen: function(item) {
				return item.HostingStatus && item.HostingStatus.Status === "stopped";
			},
			callback: function(item) {
				var msg = "Are you sure you want to delete the site configuration '" + item.Name + "'?";
				dialogService.confirm(msg, function(confirmed) {
						if (confirmed) {
							siteService.deleteSiteConfiguration(item.Location).then(deleteCallback, errorCallback);
						}
					});
			}});
		commandService.addCommand(deleteCommand, "object");
	},
	
	/**
	 * @requires eclipse.util
	 * @param projectLocation The absolute URL of a file resource.
	 * @returns {String} The path of the URL, relative to this server, with no /file/ prefix.<br>
	 * <b>FIXME:</b> this is URL manipulation; it should be done by the server
	 */
	makeRelativeFilePath: function(location) {
		var path = eclipse.util.makeRelative(location);
		var segments = path.split("/");
		var filteredSegments = dojo.filter(segments, function(s){return s !== "";});
		return "/" + filteredSegments.slice(1).join("/");
	}
};