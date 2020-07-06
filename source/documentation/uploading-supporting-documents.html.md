---
title: Uploading supporting documents | Customs Declarations End-to-End Service Guide
weight: 5
---

#Uploading supporting documents

An authenticated trader may use the service to submit files containing their documents required to support the declarations made by them. In some cases, a trader may have also received a DMSDOC notification triggered by the declaration risking process to submit their documents for a declaration that they have submitted.

The API will accept requests from the trader’s software to upload a number of files for a given declaration ID (MRN) and respond with a location (URL) to upload each file. The trader will then upload each file into an inbound file bucket. The API will return a unique file reference code to the software for each file successfully submitted by the trader via a notification.

The files uploaded by the trader will be scanned for malware and then stored in
HMRC’s document repository system and reviewed by a HMRC Caseworker.

Communication Sequence Diagram

![Comm](/documentation/resources/File_Upload_Sequence_Diagram.png)

1. Make a customs-declaration api [upload initiate request](/api-documentation/docs/api/service/customs-declarations#_submit-an-upload-initiate-request_post_accordion) specifying the number of files you want to upload.
2. Receive back a collection of AWS S3 upload urls (one per file) in the response. 
3. For each AWS S3 url upload the desired file. 
4. For every file uploaded to the AWS S3 bucket CDS will perform a number of validation checks such as virus scanning. CDS will then generate a notification for your application to indicate either a success or failure in accepting the uploaded file.
 
    a) If your application opted for push notifications from the customs-declarations api then for each file uploaded you will be sent a notification informing you of the file’s acceptance or rejection by CDS.
    
    b) If your application opted for pull notifications then your application will need to periodically poll the CDS pull-notifications api to receive the notification informing you of each file’s acceptance or rejection by CDS.