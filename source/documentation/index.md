---
title: Customs Declarations End-to-End Service Guide
weight: 1
description: Software developers, designers, product owners or business analysts. Integrate your software with Customs Declarations.
---

# Customs Declaration Service end-to-end service guide


This service guide explains how you can integrate your software with our APIs to help complete and submit Customs Declarations.

It shows how the APIs fit into various end-to-end user journeys and it is intended to help software developers, designers, product owners and business analysts to understand how your software needs to interact with HMRC systems.

## Overview
Customs Declarations Service (CDS) is replacing the Customs Handling of Import and Export Freight (CHIEF) with a modern and flexible system that can handle anticipated future import and export growth.

[More information about the Customs Declaration Service (opens in a new tab)](https://www.gov.uk/government/collections/customs-handling-of-import-and-export-freight-chief-replacement-programme).

What you need to do to get ready for the CDS will depend on how you currently make declarations using CHIEF.

[How to prepare for the Customs Declaration Service (opens in a new tab)](https://www.gov.uk/guidance/how-hmrc-will-introduce-the-customs-declaration-service).

For users who import or export outside of the European Union, there will be differences in the information they need to put in their declarations. This is due to changes to the [UK Trade Tariff (opens in a new tab)](https://www.gov.uk/government/collections/uk-trade-tariff-volume-3-for-cds) required by the Union Customs Code.

It is possible to complete and submit Customs Declarations using commercial software. To support this, we provide APIs to enable your application to:

- Make a customs declaration
- Receive business event notifications generated from requests submitted via the CDS APIs

Applications produced by external developers must subscribe to all of the CDS APIs that they wish to use. This enables access to the endpoints within the APIs. An application may subscribe to a single API or to multiple APIs.

Each subscription uniquely links a single external application to a single CDS API, and records the information associated with that unique link.

To use these APIs you must:

-	[Have an appropriate HMRC online account (opens in a new tab)](https://www.gov.uk/log-in-register-hmrc-online-services).
-	[Have an Economic Operator Registration and Identification (EORI) number (opens in a new tab)](https://www.gov.uk/eori).
-	Be registered for CDS
-	Have a working understanding of HTTP
-	Have a working understanding of OAuth2
-	Have a working knowledge of RESTful services
-	Have a working knowledge of XML

Some APIs are restricted to Community System Providers (CSPs) (5 companies - large operators who own most of the major ports)
CSPs have relationship with CHIEF – inventory linking (port to HMRC).

## End-to-end user journeys
These journeys show examples of use. Journeys for software houses and traders are broken down into:<br>

* [CDS set up activities](documentation/set-up.html#set-up)
* [submitting customs declarations](documentation/submit-customs-declarations.html#submit-customs-declarations) 

## Related API documentation
[Customs Declarations API](https://developer.qa.tax.service.gov.uk/api-documentation/docs/api)<br>
This API enables your application to submit a Customs Declaration.
[Pull Notifications API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/api-notification-pull/1.0)<br>
This API enables your application to “pull” business event notifications CDS has generated from requests submitted via the CDS APIs.<br>
Other APIs related to the CDS APIs:

-	Customs Inventory Linking Exports API
-	Customs Inventory Linking Imports API (CSP Only)
-	Bulk Data File List (list of tariff codes)

Other documentation related to CDS APIs:<br>

-	[UK Trade Tariff](https://www.gov.uk/government/collections/uk-trade-tariff-volume-3-for-cds)
-	[CDS 01 Inventory Linking Exports Service Design](https://drive.google.com/file/d/1UgbLY0M4ZzxVUjuJT0UEfGFz3mC3d7xT/view?usp=sharing)
-	[CDS 01 ILE Technical Completion Matrix](https://drive.google.com/file/d/1ahinP1dytvl1EB9K3qDkPR2kTFKtVfa0/view?usp=sharing)
-	[CDS 02 Inventory Linking Imports Service Design](https://docs.google.com/document/d/1KJB410mHnFSVO4njKGFD_4udj_K8Xc2bj2ZHy21sJRg/edit?usp=sharing)
-	[Tariff_Data_Export.pdf](https://drive.google.com/file/d/1ejsv83pYZtJ_0xrGjExQ12HcpoPYN5-6/view?usp=sharing)
-	[DispatchDataExport-XML-Data.xsd](https://drive.google.com/file/d/1MO5v5MrenBOod-ZQLmLtXp7xfqncueIh/view?usp=sharing)
-	[ECDP-Tariff Web services documentation (Annex IV)](https://drive.google.com/file/d/1-IgFb5HHlRgY3BrJxiuywMYE7TzfcCO7/view?usp=sharing)
-	[Taric User Guide](https://drive.google.com/file/d/1hc1c2Gf263yWttBGi0XP_hvandjx6k6e/view?usp=sharing)
-	[CDS – Tariff Download service -Identifying Duty Rates v1.0](https://drive.google.com/file/d/1xdvObWHuKVCQVYui2V_s7HlUyGSMkNJK/view?usp=sharing)

## Errors
Errors specific to each API are shown in the Endpoints section, under Response. See our [reference](https://developer.service.hmrc.gov.uk/api-documentation/docs/reference-guide#errors) guide for more on errors.
Specific CDS backend errors: CDS 03 Codelists and WCO References.



To change the title of the page or include additional files you'll need to edit `source/index.html.md.erb`.

If you want slightly more control, you can always use <strong>HTML</strong>.

For more detail and troubleshooting, take a look at the `README.md` file in the root of this project.
