---
title: Inventory Linking for Export Declarations | Customs Declarations End-to-End Service Guide
weight: 6
---

# Inventory Linking for Export Declarations

Submit an XML request for the consolidation, movement or querying of consignments for the purposes of inventory linking

- Consolidation - This enables the combining of consignments into one master consignment, or splitting into multiple consignments.
- Movement - Records the movement of consignments within Customs controlled storage facilities (for designated ‘Loaders’ only)
- Query - The querying of data held within the Inventory Linking Export database.

##Consolidation of consignments
Consolidation covers the management of the relationship between MUCRs, DUCRs, and other UCRs.

Exports follows a different process to Imports, in that a declaration is not immediately linked with a consignment. Rather, the declaration data awaits one or more messages from the Loader/CSP and the ‘linking’ is triggered then.

Consolidation is used to facilitate moving one master consignment, rather than multiple individual declarations. A declaration will have its own ‘DUCR’, these can be consolidated into MUCRs ( ‘masters’ consignments). These MUCRs can then also be further consolidated into other MUCRs (provided they are shut).

CDS will accept the following message to the [API endpoint](/api-documentation/docs/api/service/customs-inventory-linking-exports) that relates to:
- associating, splitting, and shutting (EAC (Export Associate Consignment)) 
- shutting (CST (Consolidation Shut Transaction))

of consignments.

##Movement of goods
CDS will accept a message to the [API endpoint](/api-documentation/docs/api/service/customs-inventory-linking-exports) (from authorised commercial entities designated as ‘Loaders’) that relates to:
- the arrival of (EAL (Export Arrival at Location))
- anticipated arrival (EAA (Export Anticipated Arrival))
- or departure (EDL (Export Depart Location))

of goods. The movement can relate to an individual DUCR, or a master MUCR.

Any movement concerning a MUCR applies to all the underlying declarations. For example, when a MUCR is arrived, all the declarations underneath the MUCR (and child MUCRs) will also be marked as arrived.

CDS system will notify CSPs of changes to a declaration if there is a movement involving it.

##Query
 
Query Service has been defined to facilitate the display of details for inventory linked consignments which includes details such as the immediate parent and child(ren) for the entered UCR.

When a UCR is entered into the query service from an actor, Inventory Linking will return the following corresponding relationships:

- The immediate parent MUCR
- The UCR under scrutiny
- The immediate children of the UCR
