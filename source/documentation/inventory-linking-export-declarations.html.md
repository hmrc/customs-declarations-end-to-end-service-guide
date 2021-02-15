---
title: Inventory linking for export declarations | Customs Declarations End-to-End Service Guide
weight: 6
---

<%= partial 'partials/google_tag_manager_js' %>

# Inventory linking for export declarations

Submit an XML request for the consolidation, movement or querying of consignments for the purposes of inventory linking:

- Consolidation - enables the combining of multiple consignments into one master consignment, or splitting one consignment into multiple consignments
- Movement - records the movement of consignments within Customs controlled storage facilities (for designated ‘Loaders’ only)
- Query - the querying of data held within the Inventory Linking Export database

##Consolidation of consignments
Consolidation covers the management of the relationship between MUCRs, DUCRs, and other UCRs.

Exports follows a different process to imports, in that a declaration is not immediately linked with a consignment. Rather, the declaration data awaits one or more messages from the Loader/CSP and the ‘linking’ is triggered then.

Consolidation is used to facilitate moving one master consignment, rather than multiple individual declarations. A declaration will have its own ‘DUCR’, these can be consolidated into MUCRs ( ‘masters’ consignments). These MUCRs can then also be further consolidated into other MUCRs (provided they are shut).

CDS will accept the following message to the [API endpoint](/api-documentation/docs/api/service/customs-inventory-linking-exports) that relates to:

- associating, splitting, and shutting (EAC (Export Associate Consignment)) 
- shutting (CST (Consolidation Shut Transaction)) of consignments

##Movement of goods
CDS will accept a message to the [API endpoint](/api-documentation/docs/api/service/customs-inventory-linking-exports) (from authorised commercial entities designated as ‘Loaders’) relating to the following status of the goods:

- arrival, or EAL (Export Arrival at Location)
- anticipated arrival, or EAA (Export Anticipated Arrival)
- departure, or EDL (Export Depart Location)

The movement can relate to an individual DUCR, or a master MUCR.

Any movement concerning a MUCR applies to all the underlying declarations. For example, when a MUCR is arrived, all the declarations underneath the MUCR (and child MUCRs) will also be marked as arrived.

The CDS system will notify CSPs of changes to a declaration if there is a movement involving it.

##Query
 
The Query Service has been defined to facilitate the display of details for inventory linked consignments which includes details such as the immediate parent and child or children for the entered UCR.

When a UCR is entered into the query service from an actor, Inventory Linking will return the following corresponding relationships:

- The immediate parent MUCR
- The UCR under scrutiny
- The immediate children of the UCR
