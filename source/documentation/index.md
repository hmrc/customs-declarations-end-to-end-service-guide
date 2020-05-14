---
title: Customs Declarations End-to-End Service Guide
weight: 1
description: Software developers, designers, product owners or business analysts. Integrate your software with Customs Declarations.
---

# Customs Declaration Service end-to-end service guide

This service guide has been created for developers working for Community System Providers (CSPs), software houses and traders. It explains how you can integrate your software with HMRC’s APIs to help complete and submit customs declarations.

## Overview
The Customs Declaration Service (CDS) is replacing the Customs Handling of Import and Export Freight (CHIEF) with a modern and flexible system that can handle anticipated future import and export growth.

[More information about the Customs Declaration Service](https://www.gov.uk/government/collections/customs-handling-of-import-and-export-freight-chief-replacement-programme).

What traders need to do to get ready for CDS will depend on how they currently make declarations using CHIEF.

[How to prepare for the Customs Declaration Service](https://www.gov.uk/guidance/how-hmrc-will-introduce-the-customs-declaration-service).

For traders who import or export outside of the European Union, there will be differences in the information they need to put in their declarations. This is due to changes to the [UK Trade Tariff](https://www.gov.uk/government/collections/uk-trade-tariff-volume-3-for-cds) required by the Union Customs Code.

## Before you can use these APIs

To use these APIs you must:

-	be registered for CDS
-	[have an Economic Operator Registration and Identification (EORI) number](https://www.gov.uk/eori).
-	be familiar with HTTP, RESTful services, XML and OAuth2

Some APIs can only be used by Community System Providers (CSPs).

## End-to-end user journeys
These journeys show examples of use. Journeys for software houses and traders are broken down into:<br>

* [developers set up activities](documentation/set-up-developers.html#set-up-for-developers)
* [submitting customs declarations](documentation/submit-customs-declarations.html#submit-a-customs-declaration) 

## Related API documentation

[Customs Declarations API](/api-documentation/docs/api/service/customs-declarations)<br>
This API enables your application to submit a Customs Declaration.

[Pull Notifications API](/api-documentation/docs/api/service/api-notification-pull)<br>
This API enables your application to “pull” business event notifications CDS has generated from requests submitted via the CDS APIs.<br>

Other APIs related to the CDS APIs:

-	[Customs Inventory Linking Exports API](/api-documentation/docs/api/service/customs-inventory-linking-exports)
-	[Customs Inventory Linking Imports API (CSP only)](/api-documentation/docs/api/service/customs-inventory-linking-imports)
-	[Bulk Data File List (list of tariff codes)](/api-documentation/docs/api/service/secure-data-exchange-bulk-download)

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
Specific CDS backend errors: CDS 03 Codelists and WCO References.
