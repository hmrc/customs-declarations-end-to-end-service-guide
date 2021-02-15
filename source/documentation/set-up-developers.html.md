---
title: Developer set up | Customs Declarations End-to-End Service Guide
weight: 2
---

<%= partial 'partials/google_tag_manager_js' %>

# Developer set-up

To develop using these APIs you must:

-	be familiar with HTTP, RESTful services, XML and OAuth2
-	be registered as a developer on the [HMRC Developer Hub] (/)
-	add at least one sandbox application on the Developer Hub

Each application you register will be assigned an HMRC ‘ApplicationId’.

You can view all the applications you have registered on the [Developer Hub Applications page](/developer/applications) where you can administer things like API subscriptions and [application credentials](/api-documentation/docs/authorisation/credentials).

Applications can be created in one of 2 possible environments:

- sandbox environments - where you start development and testing of your software
- production environment - when you are ready to go live you can request 'Production Credentials' that will create you a new application (with a new ‘ApplicationId’) in the production environment

The main differences between these 2 environments is that in the sandbox environments you will [create and use test users](/api-documentation/docs/testing/test-users-test-data-stateful-behaviour) to call the endpoints, and the release versions of CDS APIs in the sandbox will generally be ahead of those in production.
 
[More details about getting started using the sandbox environments.](/api-documentation/docs/testing) 

The purpose of CDS sandbox (also known as External Test) is to provide an HMRC platform for all external partners (CSPs, SWHs, express operators, and declarants) to complete their required assurance activities so they are confident in their readiness for migration to CDS. The CDS External Test offering has two core services: Trade Test and Trader Dress Rehearsal, which are outlined below.


## Trade Test

A functional test platform where 3rd party developers can assure their software integration against CDS APIs and a CDS back-end for all core declaration processes and notification types.
- Test trader and account data
- Process all declaration types and procedures
- Integration testing for all APIs
- Exports inventory linking, including dual running arrivals via CHIEF (HMUT)
- Simulated controls, quota, immediate payments services


## Trader Dress Rehearsal

A CDS-like service to support declarants in submitting all types of declarations to expose all actors in the supply chain to declaration processing in CDS as part of their final assurance activity prior to migration.

- Live trader and account data
- Process all declaration types and procedures
- Integration testing for all APIs
- Simulated controls, quota, immediate payments services

## Documentation

The Developer Hub documentation is intended to be a brief technical specification detailing how to submit to CDS. It details the request url, headers and example payloads for each endpoint. Any errors returned by the service are documented here too.

For substantive, detailed information on CDS business processes, technical background papers, design documents, tariff data, xsd schema details and other documents there is a suite of files available on a Google Drive.

As an example, to illustrate the difference, for errors related to a http request to the service then refer to the Developer Hub documentation. For errors related to, for example, declaration rejection codes, then refer to the Google Drive.   

Access to both the Developer Hub, and the Google Drive (contact <SDSTeam@hmrc.gov.uk>) is granted as part of CDS on-boarding.


## API subscription model

You must subscribe each application you register to the [CDS APIs](/api-documentation/docs/api) that they intend to use. 
Subscribing allows an application access to all of the endpoints of a particular API-version. An application may subscribe to as many APIs as required, but each 'application => API-version' pairing must have its own subscription enabled.


## API access control

Some of the CDS APIs (and their documentation) are only accessible to applications that have been placed in the allow list for that API. If you cannot subscribe to or access the documentation of a particular API on the developer hub, please check with [SDST](mailto:SDSTeam@hmrc.gsi.gov.uk) if your ‘ApplicationId’ needs to be added to the allow list for that API.


## API versioning

When calling a CDS endpoint you specify the version of the API you wish to use by specifying it in the ‘Accept’ request header of your request (see the specific [API documentation](/documentation/set-up-developers.html#related-api-documentation) for more details on request header values).

In the production environment there is only one version available of each of the CDS APIs (version 1.0).

In the sandbox environments however there may be 2 versions available  of a particular API, one for standard development known as ‘Trade Test’ and another version that more closely mirrors the production environment known as ‘Trader Dress Rehearsal’.  

Here is a breakdown of the CDS APIs with the versions of each that relate to ‘Trade Test’ and ‘Trader Dress Rehearsal’ respectively:

<table>
  <tr><td></td><td></td><td></td><td></td><td></td></tr>
  <tr>
    <td><strong>API Service</strong></td>
    <td><strong>Trade Test</strong></td>
    <td><strong>Trader Dress Rehearsal</strong></td>
  </tr>
  <tr>
    <td>Customs Declarations API</td>
    <td>v 2.0</td>
    <td>v 1.0</td>
  </tr>
  <tr>
    <td>Customs Declarations Information API</td>
    <td>v 1.0</td>
    <td>v 2.0</td>
  </tr>
  <tr>
    <td>Customs Inventory Linking Exports API</td>
    <td>v 1.0</td>
    <td>v 2.0</td>
  </tr>
  <tr>
    <td>Customs Inventory Linking Imports API</td>
    <td>v 1.0</td>
    <td>v 2.0</td>
  </tr>
</table>  
</br>

For your application to be able to call a particular version of an API you must: 

-	ensure that your application has access to it (by checking that the version is visible to you on the API’s documentation page)
-	[subscribe your application](/documentation/set-up-developers.html#api-subscription-model) to it (in addition to any other subscriptions you may already have for other versions)
-	modify your application’s ‘Accept’ request header value when making a call to the API to reflect the version you wish to use (see the specific [API documentation](/documentation/set-up-developers.html#related-api-documentation) for more details on request header values)

If a version of an API is not visible on the documentation page then you may need to request your application to be placed in the allow list by [SDST](mailto:SDSTeam@hmrc.gsi.gov.uk). 


## API rate limiting

To maintain good availability for every user across all our services, HMRC imposes API call rate limits on a per application basis. Each [application that you register](/developer/applications) will have its own API call quota (measured as ‘X’ calls per minute). Every request made by an application to any endpoint of any API-version will count towards this quota.

A description of the HMRC standard rate limits can be found in the [Reference Guide on HMRC’s Developer Hub](/api-documentation/docs/reference-guide#rate-limiting).

Although the standard default rate limit is appropriate for most other HMRC services, users of CDS are expected to generate higher volumes of API requests.

The existing automated HMRC business processes will still allocate the default rate limit to new subscriptions, but any CDS user will be able to increase their rate limit to 500 requests per minute by simply emailing their request to HMRC [SDST](mailto:SDSTeam@hmrc.gsi.gov.uk) (including the name and ID of the applications requiring the higher limit).

As with the default limit this higher limit of 500 requests per minute for CDS users is still seen as a starting point. If testing identifies a need for a higher limit further increases can be requested via the online request process.

If you intend to serve multiple different declarants with your software, it is recommended to register a new application with HMRC per declarant. Otherwise one declarant may adversely impact on the others by exceeding the rate limit for your single application.


## Related API documentation

If you cannot access any of the following API documentation please email with [SDST](mailto:SDSTeam@hmrc.gsi.gov.uk) to check if your ‘ApplicationId’ needs to be [added to the allow list](/documentation/set-up-developers.html#api-access-control) for that API:

- [Customs Declarations API](/api-documentation/docs/api/service/customs-declarations) - lets you submit, amend and cancel a customs declaration, and provides the ability to upload supporting documents and make arrival notifications 
- [Customs Declarations Information API](/api-documentation/docs/api/service/customs-declarations-information) - lets you query the status of submitted customs declarations
- [Pull Notifications API](/api-documentation/docs/api/service/api-notification-pull) - lets you “pull” business event notifications CDS has generated from requests submitted via the CDS APIs
- [Customs Inventory Linking Exports API](/api-documentation/docs/api/service/customs-inventory-linking-exports) - lets you link export declarations with specific consignments (Consolidate, Movement & Query)
- [Customs Inventory Linking Imports API (CSP only)](/api-documentation/docs/api/service/customs-inventory-linking-imports) - lets CSPs link import declarations with specific consignments
- [Bulk Data File List (list of tariff codes)](/api-documentation/docs/api/service/secure-data-exchange-bulk-download) - lets you integrate tariff data into your customs software application, providing an initial start-up file, daily files and monthly consolidated files throughout the year


## Authentication

###Declarants and authorized agents 

The declarant authenticates directly with us using their Government Gateway account, and grants authority to your application for specific scopes. 
We then issue an OAuth 2.0 ‘access_token’ that is specific to that declarant. Your application passes the 'access token' in subsequent API requests to user-restricted API endpoints. 
A declarant ‘access_token’ expires after 4 hours and will need to be refreshed.

Full details and examples can be found on the [HMRC Developer Hub](/)


###Community System Providers

Community System Providers (CSPs) will register privileged applications with HMRC.

The CSP system will supply data identifying each declarant during each interaction with CDS.

As CSPs are trusted by HMRC their systems will authenticate their own users. This acts a substitute for Government Gateway authentication described above.


##Error Handling Best Practices

No system guarantees 100% error-free performance and CDS is no different.

Services calling CDS need to be designed with failure in mind. There are several strategies to mitigate the errors that do occur.

###5XX errors
When CDS returns a http response code in the 5XX range the recommended response is to retry. Typically a 500 or 503 are the most likely to be received if there is an issue with CDS. The issue may be transient and hence the recommendation to retry.
The one exception in this error range is when a 501 (Not Implemented) is returned. This indicates that the endpoint is incorrect. Retrying will not help in this situation. Instead, the url should be checked and fixed.

After multiple attempts, perhaps with an exponential backoff strategy, the expectation is that this will resolve the vast majority of errors. As an example, 3-5 retries over 1-2 minutes would be a reasonable retry strategy.
Consideration should also be given to using the circuit breaker pattern.

###4XX errors
If a response code in the 4XX range is received then the API consumer should examine the response payload for more detail on the error before attempting any retry. This error range usually indicates an error with the request. The request should be modified before attempting a retry.
For example, a 400 (Bad Request) with a payload response message stating “Payload is not valid according to schema” should have it’s request payload modified so it validates against the CDS schemas and then resent.
Similarly, a 406 (Not Acceptable) indicates that the Accept header is missing or invalid. The request should be amended accordingly.


If you are receiving these errors consistently then you should report the problem via the normal routes.

There are many recommendations and plenty of guidance is available on this topic. Some useful resources are listed below -
 
- [5 Pillars of the AWS Well-Architected Framework](https://aws.amazon.com/blogs/apn/the-5-pillars-of-the-aws-well-architected-framework/)
- [Amazon whitepaper](https://docs.aws.amazon.com/whitepapers/latest/running-containerized-microservices/design-for-failure.html)
- [Implement resilient applications](https://docs.microsoft.com/en-us/dotnet/architecture/microservices/implement-resilient-applications/)
