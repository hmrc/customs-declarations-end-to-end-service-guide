---
title: Uploading supporting documents | Customs Declarations End-to-End Service Guide
weight: 5
---

# File Upload Service
This section describes the technical steps required to send a document to CDS using the file upload API endpoint on the Customs Declaration API. In addition, it outlines the business processes associated with the file upload process to provide the user with an understanding of how this section is linked with declaration processing on CDS.

The Document Upload UI is out of scope for this service guide and will be covered in a separate user guide produced by the CDS programme.

### Background
Currently, CHIEF does not provide Traders with a service to digitally upload documentation to support the processing of Customs Import/Export Declarations. Traders provide the supporting documentation via a multitude of channels and document mediums and HMRC National Clearance Hub (NCH) caseworkers currently manually receive and process documentation provided by declarants in support of submitted Customs declarations. 

Under the Customs Declaration Service (CDS), HMRC has delivered the CDS Digital Secure File Upload Service to remove the need for the manual processing of supporting documentation for declarations submitted on CDS. The CDS Digital Secure File Upload Service allows the documentation uploaded in support of a declaration to be automatically transferred into HMRC’s case management solution for review.

## Document Upload Process
#### Process Overview
The File Upload API will accept requests from the trader’s software to upload a number of files for a given declaration ID (MRN) and respond with a location (URL) to upload each file. The trader will then upload each file into an inbound file bucket. 

The API will return a unique file reference code to the software for each file successfully submitted by the trader via a Digital notification. This file reference code can be used in future correspondence with HMRC. Please note that the submitter of the file will not receive a confirmation notification from back-end CDS systems that confirm the file has been matched to the declaration.

The CDS system uses the MRN to link documents uploaded via the Secure File Upload Service and the original declaration. HMRC Caseworkers will be notified when each document uploaded by the trader is received and also when all files uploaded together as a group for a declaration have been received. When all files have been received, HMRC Caseworkers will review the documents they contain against the case for the declaration ID provided in the original API call. 

Currently, if an HMRC Caseworker requires a submission of supporting documents, the Trader will be notified via email. If the HMRC Caseworker finds any issues with the submitted documents, they will notify the trader to upload their documents again. Under current processes, the NCH will contact the declarant via email in the event that further information is required. HMRC is currently working to deliver an automated solution for handling such requests and this document will be updated once the solution has been confirmed.

In such cases, the HMRC caseworker will also reset any SLAs defined around this process. 

The files uploaded by the trader will be scanned for malware and then stored in HMRC’s document repository system where they will be retained in accordance with HMRC policies (6 + current year).

#### Initiating an Upload and Documentary Controls
An authenticated trader may use the service at any time to submit files containing their documents required to support the declarations made by them. 

In some cases, a trader may have also received a DMSDOC notification triggered by the declaration risking process (Route 1 or Route 3) to submit their documents for a declaration that they have submitted. However, it is not necessary to wait for a DMSDOC notification to upload a file to HMRC via the CDS Digital Secure File Upload Service.

It should be noted that the DMSDOC notification will not link to the Secure File Upload Service, nor will it specify the documents which must be uploaded. The same applies to CSP notifications and the Declaration Information API which return the routing status for the declaration, but not which document(s) are required (see Section 1.3 References). In the event of a documentary check, a declarant can either choose to upload the particular document that is expected to have triggered the control (e.g. a licence document) or all documentation associated with the declaration.

## Using the File-Upload API endpoint

File upload is a multi-stage process. It starts with a single call to an endpoint on the Customs Declarations service to request S3 upload metadata for sending one or more files. This call returns one or more URLs with related “Fields”. These in turn are split into separate upload requests to S3, one per file.
### High-level Steps
#### Phase 1 – Request the URL
##### Step 1 - Initiate upload
Start the sequence of steps with a call to the file upload endpoint on the Customs Declarations service. This can be for one or more files. The payload schema can be found in the zip of schemas and example messages in the Customs Declarations documentation on the Developer Hub. Examples are provided below.
##### Step 2 - Parse response
For each file specified in the initiate request, the response will contain a one-time S3 URL used to upload a file and a collection of name/value pairs in a “Fields” collection to send with the file upload.

Multiple individual sets of urls and “Fields” collections may be returned. E.g. if five files are initiated in the request above then five URLs with five linked “Fields” collections will be returned in the payload response.

#### Phase 2 – Upload the Files
##### Step 3 - POST the file
For each file specified in the initiate request, compose a POST request to the S3 URL. In the fields of the form include all the name/value pairs taken from the “Fields” collection in the initiate response payload. Include the actual file to upload as the final field in the form with the name “file”.
##### Step 4 - Await notification
An asynchronous notification will indicate the success or failure of the upload. These are retrieved like declaration notifications. Failures can be due to invalid file types, files too large etc.

### Process Flow
The diagram below outlines the high-level functionality described in this Phase 2 above.

![Comm](/documentation/resources/file-upload-process-flow.png)

## Detailed Steps
### Step 1 - Initiate upload
Call the `/customs/declarations/file-upload` endpoint to initiate the file-upload process.
A typical request payload -

```xml
<hmrc:FileUploadRequest xmlns:hmrc="hmrc:fileupload">
 <hmrc:DeclarationID>DEC123</hmrc:DeclarationID>
 <hmrc:FileGroupSize>1</hmrc:FileGroupSize>
 <hmrc:Files>
   <hmrc:File>
     <hmrc:FileSequenceNo>1</hmrc:FileSequenceNo>
     <hmrc:DocumentType>Licence</hmrc:DocumentType>
   </hmrc:File>
 </hmrc:Files>
</hmrc:FileUploadRequest>
```

#### Rules for File Initiation Requests
* A maximum of 11 files may be initiated in a single request. To initiate two file uploads with no optional elements e.g.

```xml
<hmrc:FileUploadRequest xmlns:hmrc="hmrc:fileupload">
       <hmrc:DeclarationID>DEC123</hmrc:DeclarationID>
       <hmrc:FileGroupSize>2</hmrc:FileGroupSize>
       <hmrc:Files>
         <hmrc:File>
           <hmrc:FileSequenceNo>1</hmrc:FileSequenceNo>
         </hmrc:File>
         <hmrc:File>
           <hmrc:FileSequenceNo>2</hmrc:FileSequenceNo>
         </hmrc:File>
       </hmrc:Files>
      </hmrc:FileUploadRequest>
```

* The permitted file types are pdf, jpg/jpeg, png, doc/docx, xls/xslx and txt which correspond to the following mime types (note the type is determined from the file contents and not the extension) -
  - application/pdf
  - image/jpeg
  - image/png
  - application/msword
  - application/vnd.openxmlformats-officedocument.wordprocessingml.document
  - application/vnd.ms-excel
  - application/vnd.openxmlformats-officedocument.spreadsheetml.sheet
  - text/plain
  
* Optional SuccessRedirect and ErrorRedirect elements (example below) may be added to each file upload to redirect when there is a successful or failed upload. This is intended for developers creating UI applications that interact with this endpoint. For API interactions it can be ignored.

```xml
<hmrc:FileUploadRequest xmlns:hmrc="hmrc:fileupload">
          <hmrc:DeclarationID>DEC123</hmrc:DeclarationID>
          <hmrc:FileGroupSize>1</hmrc:FileGroupSize>
          <hmrc:Files>
            <hmrc:File>
              <hmrc:FileSequenceNo>1</hmrc:FileSequenceNo>
              <hmrc:DocumentType>Licence</hmrc:DocumentType>
              <hmrc:SuccessRedirect>https://success-redirect.com</hmrc:SuccessRedirect>
              <hmrc:ErrorRedirect>https://error-redirect.com</hmrc:ErrorRedirect>
            </hmrc:File>
          </hmrc:Files>
        </hmrc:FileUploadRequest>
```

#### Http Headers
The headers are described in detail in the file-upload endpoint section of the  Customs Declarations service on the Developer Hub. To summarise, they are -


|Header Name|Mandatory?|Example|Notes|
|-----------|----------|-------|--------|
|Accept|Yes|application/vnd.hmrc.2.0+xml|1|
|Content-Type|Yes|application/xml; charset=UTF-8||
|X-Badge-Identifier|For CSPs|ABC123||
|X-Eori-Identifier|For CSPs|GB123456789000||

1. Accept headers by environment -

* Production - application/vnd.hmrc.1.0+xml
* Trade Test - application/vnd.hmrc.2.0+xml
* Trader Dress Rehearsal - application/vnd.hmrc.1.0+xml
See screenshot below for an example using Postman.

#### Response Codes
A successful initiate upload returns a 200 OK code with a payload containing an S3 href and a fields collection, one per file upload initiated (see Step 2 below).

A failure is indicated by a 4XX or 5XX code. E.g. 

For an invalid XML Payload an error code 400 is returned with the following body -
 
```xml
<errorResponse>
  <code>BAD_REQUEST</code>
  <message>Payload is not valid according to schema</message>
  <errors>
    <error>
      <code>xml_validation_error</code>
      <message>Error at line 13, column 13: no declaration found for element 'unknown'</message>
    </error>
  </errors>
</errorResponse>
```

For an internal server error an error code 500 is returned with the following body -

```xml
<errorResponse>
  <code>INTERNAL_SERVER_ERROR</code>
  <message>Internal server error</message>
</errorResponse>
```

For other errors see the Developer Hub [documentation](api-documentation/docs/reference-guide).

### Step 2 - Parse response
A typical response payload resulting from the first request above -

```xml
<FileUploadResponse xmlns="hmrc:fileupload">
   <Files>
       <File>
           <Reference>3245a5c2-a128-4205-8a8d-f2dcdb549999</Reference>
           <UploadRequest>
               <Href>https://fus-inbound-8264eea94f87aa9999.s3.amazonaws.com</Href>
               <Fields>
  <x-amz-meta-callback-url>https://some-callback-url</x-amz-meta-callback-url>
  <x-amz-date>20200811T081107Z</x-amz-date>
  <x-amz-credential>AKIAIHSAVV7BWA/209999/eu-west-2/s3/aws4_request</x-amz-credential>
  <x-amz-meta-upscan-initiate-response>2020-08-11T08:11:07.126Z</x-amz-meta-upscan-initiate-response>
  <x-amz-meta-upscan-initiate-received>2020-08-11T08:11:07.126Z</x-amz-meta-upscan-initiate-received>
 <x-amz-meta-request-id>n/a</x-amz-meta-request-id>
 <x-amz-meta-original-filename>${filename}</x-amz-meta-original-filename>
 <x-amz-algorithm>AWS4-HMAC-SHA256</x-amz-algorithm>
 <key>3245a5c2-a128-4205-8a8d-f2dcdb549999</key>
 <acl>private</acl>
 <x-amz-signature>0b0f92e7fb8ad67b5973711a7d059184349a2</x-amz-signature>
 <x-amz-meta-session-id>n/a</x-amz-meta-session-id>
 <x-amz-meta-consuming-service>customs-declarations</x-amz-meta-consuming-service>
 <policy>eyJleHBpcmF0aW9uIjoiMj....</policy>
               </Fields>
           </UploadRequest>
       </File>
   </Files>
</FileUploadResponse>
```

Note that when multiple files are initiated in the request a single response is returned containing multiple File elements. Each of these are then composed into separate POST requests to S3 - see next step.

### Step 3 - Upload the file

Upload a file by

* Executing a http POST request containing a form submission to the url extracted from the "Href" field in the response above
* Include all the name/value pairs from the "Fields" collection in the form 
* The "file" field containing the upload file must be the last field in the submitted form
* Use multipart encoding (multipart/form-data)
* Each file size must not exceed 10MB
* The one-time url and associated metadata expires after 7 days. If the file is not uploaded in that time, then a new initiate request will be needed.
* See the AWS S3 [documentation](https://docs.aws.amazon.com/AmazonS3/latest/dev) for more details including response and error codes

If multiple files are specified in the initiate request, then there will be an equivalent number of File elements in the response containing separate urls and Fields collections. Each of these should be composed into separate S3 upload requests.

See screenshot below for an example using Postman.

### Step 4 - Await notification
A notification indicating the success or failure of the upload will be sent after a short period of time. These are sent like any other declaration notification. There is one notification per file uploaded to S3.

If declaration notifications are "pushed" then file upload notifications will be pushed too. 

For "pull" notifications they can be retrieved by using the id in the “Reference” element in the file-upload response as the conversationId.

Failure reasons include too large a file, invalid file type, virus detected etc.

A typical successful notification is -

```xml
<Root xmlns="hmrc:fileupload">
  <FileReference>3245a5c2-a128-4205-8a8d-f2dcdb54296b</FileReference>
  <BatchId>904067f4-0da4-47b7-8702-66eb76c72d97</BatchId>
  <FileName>Sample for S3 upload.pdf</FileName>
  <Outcome>SUCCESS</Outcome>
  <Details>Thank you for submitting your documents. Typical clearance times are 2 hours for air and 3 hours for maritime declarations. During busy periods wait times may be longer.</Details>
</Root>
```

A typical failure notification is -

```xml
<Root xmlns="hmrc:fileupload">
  <FileReference>ff7c82a9-21b1-4f73-a60d-984c7d03324e</FileReference>
  <Outcome>REJECTED</Outcome>
  <Details>MIME type [image/gif] is not allowed for service: [customs-declarations]</Details>
</Root>
```


## File Upload Capabilities in External Test
Due to technical limitations, the file upload service in External Test is not fully integrated with the CDS back-end. This is to allow for automated resolution of controls without a requirement for manual intervention as part of continued testing with external parties.

A documentary control can be triggered in External Test by using the appropriate ‘trigger word’ in the Goods Description field for the commodity code (e.g. timportsdocblocking). Subsequently, it is possible for users of External Test to upload a file via the file upload endpoint. However, please be aware that these two processes will not be linked and the uploading of a file is not necessary to resolve an open documentary control in either External Test environment.

There are not currently plans to deliver the Secure File Upload UI into either of the External Test services (Trade Test, Trader Dress Rehearsal).

#### Trade Test
##### Functionality from TTM11.0
Beginning in August 2020 (TTM11.0), the functionality available in Trade Test will be expanded to provide a richer experience that more closely aligns to the behaviour in Production. The revised capability in Trade Test for the file upload API endpoint will be as follows:

1. The end user submits a request to the customs/declarations/file-upload endpoint 
1. A synchronous http 200 response is returned to the end user along with a response body containing the S3 bucket location and other details required for the file upload. These are real S3 bucket details and none of the information is stubbed. 
1. End user would upload the file to s3 bucket location in a POST call by providing the details returned from step 2 for the following type of files -
application/pdf,application/msword,application/vnd.ms-excel,image/png,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,image/jpeg,text/plain
1. The file will undergo virus scan checks and if the scan is successful the end user will be notified via an asynchronous notification that the file upload has been successful otherwise they will be notified that the file has failed the virus scan and has been quarantined. This notification will be received as a push or pull notification, depending on the presence or absence of a callback url during the API subscription process.

#### Trader Dress Rehearsal
From August 2020, the file upload API endpoint will be available in the Trader Dress Rehearsal with the same functionality outlined above for Trade Test as delivered in TTM11.0.

### Screenshots using Postman

#### Sample file-upload initiate request and response

![initiate](/documentation/resources/file-upload-initiate.png)

#### Sample S3 upload request and response result with headers

![s3-upload](/documentation/resources/s3-upload.png)
