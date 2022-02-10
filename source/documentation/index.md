---
title: Customs Declarations End-to-End Service Guide
weight: 1
description: Software developers, designers, product owners or business analysts. Integrate your software with Customs Declarations.
---

# Customs Declaration Service end-to-end service guide

This guide explains how you can integrate your software with our APIs to complete a customs declaration.

It shows how the APIs fit into various end-to-end user journeys. It is also intended to help software developers, designers, product owners or business analysts understand how your software needs to interact with HMRC systems.

## Overview
The Customs Declaration Service (CDS) is replacing the Customs Handling of Import and Export Freight (CHIEF) with a modern and flexible system that can handle anticipated future import and export growth.

[More information about the Customs Declaration Service](https://www.gov.uk/government/collections/customs-handling-of-import-and-export-freight-chief-replacement-programme).


For imports or exports outside outside of the European Union, there will be differences in the information they need to put in their declarations. This is due to changes to the [UK Trade Tariff](https://www.gov.uk/government/collections/uk-trade-tariff-volume-3-for-cds) required by the Union Customs Code.

## End-to-end user journeys
These journeys show examples of use. 

* [developers set up](documentation/set-up-developers.html#set-up-for-developers)
* [submitting import and export customs declarations](documentation/submitting-import-and-export-customs-declarations.html#submit-a-customs-declaration)
* [receiving notifications](documentation/notifications.html)  
* [uploading supporting documentation](documentation/uploading-supporting-documents.html)
* [query declaration status](documentation/query-declaration-status.html)   
* [inventory linking for export declarations](documentation/inventory-linking-export-declarations.html)
* [making arrival notifications](documentation/arrival-notifications.html)
* [validating import movements (CSPs only)](documentation/validating-import-movements.html)

Note that links in this guide to other CDS APIs (except for Customs Inventory Linking Exports API) will only work when logged in and subscribed.

### Changelog

#### Version 0.8 

14 September 2021

What changed:

* Added document The Path To Production.pdf

#### Version 0.7

11 June 2021

What changed:

* Added [Appendix section](/documentation/appendix.html) and following documentation:
  - Annex-IV-extraction-elements-1.8.5
  - CDS - Tariff Download Service - Identifying Duty Rates v1.0
  - DispatchDataExport.xsd
  - Dispatch Data Export XML
  - Tariff Data Export

#### Version 0.6

5 March 2021

What changed:

* Additional guidance for push notification endpoints

#### Version 0.5

18 February 2021

What changed:

* Updated list of permitted file types for the file-upload endpoint
* Updated the 5XX retry notification interval 

#### Version 0.4

18 January 2021

What changed:

* Added Documentation section to Developer set-up page 

#### Version 0.3

21 December 2020

What changed:

* Added error handling section

#### Version 0.2

10 November 2020

What changed:

* Added more detail to the file upload section

#### Version 0.1

15 October 2020

* First release

## Technical Documentation
This area houses the latest versions of documentation issued to CSPs and SWDs, detailing CDS functionality and how to develop for the service. The following documentation will include:

* Technical Documentation: Documentation and specifications that provide guidance on how to develop for CDS
* CSP Only Technical Documentation: CSP only documentation and specifications that provide guidance on how to develop for CDS
* Policy Documentation: CDS Tariff ("Paper" tariff) which provides guidance on how to complete a policy-compliant declaration
* Trade Test Business Documentation: Documentation issued specifically for Trade Test, on the scope and functionality available in the trade test
* Sample XMLs: Example XML messages that can be submitted by SWDs and CSPs to test the functionality available in Trade Test
  
  Documentation will be updated periodically, with communications being distributed by the Software Developer Support Team to inform users of any changes.
  The latest version of all documentation can be found in the zip file below.
  
Please click on the link below to download the zip file:

 <p class="govuk-body-l" style="font-size: 24px;">
   <a href="./documentation/resources/CDS_Technical_Documentation.zip" class="govuk-link">CDS Technical Documentation</a>
 </p>

 <p class="govuk-body-s" style="font-size: 16px;margin-bottom: 15px;">ZIP, 31.8MB</p>

 <p class="govuk-body-s" style="font-size: 16px;margin-bottom: 15px;">The ZIP file contains Office files (docx, pptx, xlsx). Open in your preferred application.</p>
 
