---
title: Submitting customs declarations | Customs Declarations End-to-End Service Guide
weight: 3
---

# Submitting customs declarations

For both import and export declarations.

When you bring goods into the UK you must make a full declaration unless you are authorised to use simplified declarations.


## Submit new declaration

### Submitter journey overview
The submitter of a declaration can be:

- an individual trader
- an agent acting on their behalf
- a CSP

<img src="resources/Submit-a-customs-declaration.svg"/>

### 1. Submit declaration
Your software should use the [Customs Declarations API](/api-documentation/docs/api/service/customs-declarations) to do this - specifically the [Submit a customs declaration](/api-documentation/docs/api/service/customs-declarations/1.0#_submit-a-customs-declaration_post_accordion) endpoint.

If you are a CSP you must identify the submitter of the declaration (the declarant) in your requests by supplying their EORI in the ‘X-Submitter-Identifier’ header field or, when their EORI is not known, the declarant's Badge ID as its value.

As a CSP you may also, if desired, include an ‘X-Badge-Identifier’ header field that contains the declarant’s Badge ID value. If provided, this value will then be included in any subsequent response back to the CSP from CDS about that particular declaration


### 2. Receive response
You will receive a synchronous response confirming that your declaration has been received.

This response will include a Conversation ID that you can use to identify notifications that correspond to this particular declaration.


### 3. Receive notifications related to declaration
After a short time one or more notifications related to your declaration will be generated.

How you receive [notifications](/documentation/notifications.html) depends on whether you have set up [push](/documentation/notifications.html#push-notifications) or [pull](/documentation/notifications.html#pull-notifications) notifications for your subscription to the [Customs Declarations API](/api-documentation/docs/api/service/customs-declarations).

The exact message flow and types of notifications that you can expect to receive during the declaration’s life cycle depends on the type of declaration you are submitting. A detailed explanation of all the different declaration types and their process flow can be found in the [CDS 10 End to End Sequence Diagrams document](/documentation/resources/CDS 10 End to End Sequence Diagrams v5.2 20200409.docx).


## Amend a submitted customs declaration

CDS allows the submission of declaration amendments which will cause a re-validation of the declaration. 

Your software should use the [Customs Declarations API](/api-documentation/docs/api/service/customs-declarations) to do this, specifically the [Submit a Customs Amend Declaration endpoint](/api-documentation/docs/api/service/customs-declarations#_submit-a-customs-amend-declaration_post_accordion).

Amending a declaration follows a similar process to submitting. The exact message flow and types of notifications that you can expect to receive after an amendment depends on the type of declaration you are amending. A detailed explanation of all the different declaration types and their process flow can be found in the [CDS 10 End to End Sequence Diagrams document](/documentation/resources/CDS 10 End to End Sequence Diagrams v5.2 20200409.docx).


## Cancel a submitted customs declaration

To cancel (also known as invalidate) a submitted declaration your software should use the [Customs Declarations API](/api-documentation/docs/api/service/customs-declarations) to do this, specifically the [Submit a cancellation](/documentation/submitting-customs-declarations.html#cancel-a-submitted-customs-declaration) request endpoint.

The exact message flow can be found in the [CDS 10 End to End Sequence Diagrams document](/documentation/resources/CDS 10 End to End Sequence Diagrams v5.2 20200409.docx)