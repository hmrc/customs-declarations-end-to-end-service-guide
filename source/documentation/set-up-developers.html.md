---
title: Set up | Customs Declarations End-to-End Service Guide
weight: 2
---

# Developers set-up

To develop using these APIs you must:

- [be registered as a developer on the HMRC Developer Hub](https://developer.service.hmrc.gov.uk/)
- add at least one sandbox application on the Developer Hub

Each application you register will be assigned a HMRC ‘ApplicationId’

You can view all the applications you have registered on the [Developer Hub Applications page](developer/applications)

There are 2 types of Developer Hub applications:

- sandbox - you start your development with these
- production - when you are ready to go live you can request 'Production Credentials' that will create you a new production application (with a new ‘ApplicationId’) in the live environment


## API Subscription Model
### Application Subscription

You must subscribe each application to the [CDS APIs](api-documentation/docs/api) that they intend to use. 
Subscribing allows an application access to all of the endpoints of an API. An application may utilise as many APIs as required, but each application-API pairing must have its own subscription enabled.

## Notifications
At various stages of the asynchronous customs declaration process your application will need to be notified by HMRC systems of certain events resulting from interactions with one of the CDS APIs.  All of the CDS APIs that use notifications offer the choice of either push or pull notifications. 

Part of an application’s subscription to a CDS API defines how notifications from that API will be delivered to that particular application. 

If the subscription specifies a push notification callback URL, that will indicate that the API should use push notifications. Notifications will be sent to the supplied callback URL by CDS.

If the subscription omits the callback URL, that will indicate to the API that pull notifications should be used. Your application will need to retrieve notifications from CDS.


**Push notifications**

CDS ‘pushes’ notifications as they are generated, and the trade system needs to always be ready to receive them at the specified callback URL.          

CDS will automatically try to resend notifications that fail to be delivered to the specified callback URL (up to a maximum number of retries).

If CDS successfully delivers a notification it cannot be resent. There are no API endpoints that would enable a re-delivery to be requested.


**Pull notifications**

The trade system ‘pulls’ notifications when it is ready to do so.

API endpoints allow identification and retrieval of the selected notifications.

Pull retrieval also allows (within limits) previously read notifications to be re-read if necessary.

Read more about using the [Pull notifications API](api-documentation/docs/api/service/api-notification-pull).

