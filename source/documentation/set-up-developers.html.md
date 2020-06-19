---
title: Set up | Customs Declarations End-to-End Service Guide
weight: 2
---

# Developers set-up

To develop using these APIs you must:

-	be familiar with HTTP, RESTful services, XML and OAuth2
-	be registered as a developer on the [HMRC Developer Hub] (https://developer.service.hmrc.gov.uk/)
-	add at least one sandbox application on the Developer Hub

Some APIs can only be used by Community System Providers (CSPs).

To develop using these APIs you must:

- be registered as a developer on the [HMRC Developer Hub](/)
- add at least one sandbox application on the Developer Hub

Each application you register will be assigned a HMRC ‘ApplicationId’

You can view all the applications you have registered on the [Developer Hub Applications page](developer/applications)

There are 2 types of Developer Hub applications:

- sandbox - you start your development with these
- production - when you are ready to go live you can request 'Production Credentials' that will create you a new production application (with a new ‘ApplicationId’) in the live environment


## API Subscription Model

You must subscribe each application to the [CDS APIs](api-documentation/docs/api) that they intend to use. 
Subscribing allows an application access to all of the endpoints of an API. An application may utilise as many APIs as required, but each application-API pairing must have its own subscription enabled.


## API Access Control

Some of the CDS APIs (and their documentation) are only accessible to applications that have been whitelisted for that API. If you can not subscribe to or access the documentation of a particular API on the developer hub please check with [SDST](mailto:SDSTeam@hmrc.gsi.gov.uk) if your ‘ApplicationId’ needs to be added to the whitelist for that API.


## API Versioning

In the production environment there is only one version of each CDS API which is version ‘1.0’.
In the sandbox environment however there may be more than one version of a particular API, made available for the purposes of testing new pre-release features and endpoints.  
For your application to be able to call a particular version of an API you must: 

-	ensure that your application has access to the desired version of that particular API (by checking that the version is visible to you on API’s documentation page). If it is not visible then you may need to request to be [whitelisted by SDST](documentation/set-up-developers.html#api-access-control).
-	[subscribe your application](documentation/set-up-developers.html#api-subscription-model) to that particular ‘API - version’ combo (in addition to any other subscriptions that might already exist to that API for different versions).
-	modify your application’s ‘Accept’ request header value when making a call to the API to reflect the version you wish to use (see the specific [API documentation](documentation/set-up-developers.html#related-api-documentation) for more details on request header values).


## API Rate Limiting

A description of the HMRC standard rate limits can be found in the [Reference Guide on HMRC’s Developer Hub](/api-documentation/docs/reference-guide#rate-limiting)

Although the standard default rate limit is appropriate for current HMRC services, users of CDS are expected to generate higher volumes of API requests. In recognition of this fact, CDS users will be ‘pre-approved’ for a higher initial rate limit of 500 requests per minute.

The existing automated HMRC business processes will still allocate the default rate limit to new subscriptions, but any CDS user will be able to increase their rate limit to 500 requests per minute by simply emailing their request to HMRC SDST (including the name and ID of the applications requiring the higher limit).

As with the default 150 request per minute limit, the higher limit of 500 for CDS users is still seen as a starting point. If it is sufficient for an organisation, then there is no need to change it. If testing identifies a need for a higher limit however, a further increase can be requested via the online request process.

## Related API documentation

If you can not access any of the API documentation links below please check with [SDST](mailto:SDSTeam@hmrc.gsi.gov.uk) if your ‘ApplicationId’ needs to be [added to the whitelist](documentation/set-up-developers.html#api-access-control) for that API.

[Customs Declarations API](/api-documentation/docs/api/service/customs-declarations)

This API enables your application to submit, amend and cancel a customs declaration. Also provides the ability to upload supporting documents and make arrival notifications. 

[Customs Declarations Information API](/api-documentation/docs/api/service/customs-declarations-information)

This API enables you to query the status of submitted customs declarations.

[Pull Notifications API](/api-documentation/docs/api/service/api-notification-pull)

This API enables your application to “pull” business event notifications CDS has generated from requests submitted via the CDS APIs.

[Customs Inventory Linking Exports API](/api-documentation/docs/api/service/customs-inventory-linking-exports)

This API enables you to link export declarations with specific consignments. (Consolidate, Movement & Query)

[Customs Inventory Linking Imports API (CSP only)](/api-documentation/docs/api/service/customs-inventory-linking-imports)

This API enables you (as a CSP) to link import declarations with specific consignments.

[Bulk Data File List (list of tariff codes)](/api-documentation/docs/api/service/secure-data-exchange-bulk-download)

This API allows you to integrate tariff data into your Customs software application. It provides an initial start-up file, daily files and monthly consolidated files throughout the year.


## Authentication

###Declarants & Authorized Agents 

The end user authenticates directly with us using their Government Gateway account, and grants authority to your software for specific scopes. We then issue an OAuth 2.0 ‘access_token’ that is specific to the end user. Your application passes the access token in subsequent API requests to user-restricted API endpoints. A user ‘access_token’ expires after 4 hours and will need to be refreshed.

Full details and examples can be found on the [HMRC Developer Hub](/)


###Community System Providers

Community System Provider’s (CSP) may register privileged applications with HMRC.

Privileged applications do not require each end user to have Government Gateway credentials.

Following registration, the credentials you are supplied with can be used to generate a Time-based One-Time Password (TOTP) code which is exchanged for an access_token.
