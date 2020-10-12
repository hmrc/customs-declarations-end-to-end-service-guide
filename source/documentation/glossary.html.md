---
title: Glossary | Customs Declarations End-to-End Service Guide
weight: 9
---

# Glossary

## Import Declaration Types:

- full
- simplified
- supplementary
- final supplementary
- pre-lodged - made before the goods arrive in the UK
- arrived - made after the goods arrive in the UK (held by customs)


## Export Declaration Types:

- full
- simplified
- supplementary


## EORI 
You need an Economic Operator Registration and Identification number to move goods between the UK and non-EU countries.


## ICR
Inventory consignment reference. The CSP inventory system consignment is linked with CDS by ICRs, which will be cross-referenced against the declaration and used to identify the consignment and declaration in subsequent messages between CDS and the CSP inventory system.

The ICR is declared as the master unique consignment reference (MUCR).


## ICS

Import clearance status codes

<table>
  <tr><td></td><td></td><td></td><td></td></tr>
  <tr>
    <td><strong>Status</strong></td>
    <td><strong>Code</strong></td>
    <td><strong>Description</strong></td>
    <td><strong>CHIEF Equivalent</strong></td>
  </tr>
  <tr>
    <td>Declaration Validation</td>
    <td>1</td>
    <td>
        The declaration is currently within validation and is not yet accepted, registered or rejected. This code will be received
        for any initial linking of the declaration to the consignment on the inventory.
    </td>
    <td>00</td>
  </tr>
  <tr>
    <td>Declaration Goods Release</td>
    <td>2</td>
    <td>
        This status will be received once the declaration has a positive customs position but either control or the debt is provisional. 
        However, the goods can be released. This will be received as part of a Declaration Status Notification.
    </td>
    <td>01</td>
  </tr>
  <tr>
    <td>Declaration Clearance</td>
    <td>3</td>
    <td>
        This status will be received once the declaration has a positive customs position and the control/debt is finalised.
        The majority of declaration will move to this status and skip release. This will be received as part of a Declaration Status Notification.
    </td>
    <td>01</td>
  </tr>
  <tr>
    <td>Declaration Invalidated</td>
    <td>4</td>
    <td>
        This status will be received as part of a Declaration Status Notification once the decision has been taken to invalidate the declaration. 
        </br></br>
        <strong>N.B. It has been noted that this value is not granular enough for our current business process and a requirement has been raised to change this.</strong>
    </td>
    <td>92 / 07 / 09 / 05</td>
  </tr>
  <tr>
    <td>Declaration Rejected</td>
    <td>5</td>
    <td>If the declaration is rejected, then a Declaration Status Notification will be received with this code.</td>
    <td>N/A</td>
  </tr>
  <tr>
    <td>Declaration Handled Externally</td>
    <td>6</td>
    <td>
        This status will be received as part of a Declaration Status Notification once the decision has been taken to take the declaration off system. 
        This will happen extremely rarely, e.g. a declaration with 999 items receives a partial quota allocation.
    </td>
    <td>N/A</td>
  </tr>
  <tr>
    <td>Declaration Correction Validation</td>
    <td>7</td>
    <td>
        The amendment for the declaration is currently within validation and is not yet registered or rejected. This code will
        be received for any initial linking of the ‘stand-in’ declaration to the consignment on the inventory.
    </td>
    <td>22</td>
  </tr>
  <tr>
    <td>Advance Declaration Registration</td>
    <td>8</td>
    <td>Will not be sent to CSPs</td>
    <td>N/A</td>
  </tr>
  <tr>
    <td>Declaration Acceptance</td>
    <td>9</td>
    <td>Will not be sent to CSPs</td>
    <td>N/A</td>
  </tr>
  <tr>
    <td>Declaration Acceptance at Goods Arrival</td>
    <td>10</td>
    <td>Will not be sent to CSPs</td>
    <td>N/A</td>
  </tr>
  <tr>
    <td>Declaration Rejection at Goods Arrival</td>
    <td>11</td>
    <td>If the declaration fails re-validation at the point of arrival, then this notification will be sent to CSPs.</td>
    <td>R (export SOE)</td>
  </tr>
  <tr>
    <td>Declaration Corrected</td>
    <td>12</td>
    <td>Will not be sent to CSPs</td>
    <td>N/A</td>
  </tr>
  <tr>
    <td>Declaration Supplemented</td>
    <td>13</td>
    <td>Will not be sent to CSPs</td>
    <td>N/A</td>
  </tr>
  <tr>
    <td>Declaration Risked</td>
    <td>14</td>
    <td>Notification that the declaration has now been risked and will contain a specific ROE code.</td>
    <td>N/A</td>
  </tr>
  <tr>
    <td>Customs Position Determined</td>
    <td>15</td>
    <td>Will not be sent to CSPs</td>
    <td>N/A</td>
  </tr>
  <tr>
    <td>Declaration Clearance after Goods Release</td>
    <td>16</td>
    <td>Will not be sent to CSPs</td>
    <td>N/A</td>
  </tr>
  <tr>
    <td>Insufficient Guarantees</td>
    <td>17</td>
    <td>
        Will be sent as part of a Declaration Status Notification to inform of the need for the trader to take action on their deferment account. 
        Suggests that there may be a delay to the declaration processing.
    </td>
    <td>N/A</td>
  </tr>
</table>


## Inventory Reference 
This is only used for import declarations and is the same as a MUCR.


## LRN 
The Local Reference Number (LRN) defined by the declarant and submitted in Data Element 2/5 will need to be unique for a period of 2 days from the point of declaration acceptance. It can only be reused once the 2 calendar days have elapsed.


## MRN 
A Movement Reference Number (MRN) is a globally unique identifier for a declaration assigned by CDS once a declaration is submitted.


##Office of Entry

An ‘Office of Entry’ is a location into which goods arrive in the UK. There are 2 types:
- Inventory Linked - where CSPs make the ‘arrival of goods’ notification to customs
- Non-Inventory Linked - where traders must make the ‘arrival of goods’ notification to customs themselves

## Participants

- Declarant - the owning person/company responsible for make a declaration
- Submitter - an individual trader, authorised agent or CSP that electronically submits a declaration to CDS via the APIs 
- CSP - Community System Provider, they control the major Office of Entry for goods into the UK


## ROE
Route of examination codes:

<table>
  <tr><td></td><td></td><td></td><td></td></tr>
  <tr>
    <td><strong>Route</strong></td>
    <td><strong>Code</strong></td>
    <td><strong>Description</strong></td>
    <td><strong>CHIEF Equivalent</strong></td>
  </tr>
  <tr>
    <td>Documentary Control</td>
    <td>1</td>
    <td>A risk has been identified that requires the declarant to submit documentation for checking. The goods are required to be held</td>
    <td>1</td>
  </tr>
  <tr>
    <td>Physical / External Party Control</td>
    <td>2</td>
    <td>A risk has been identified which requires the goods to be physically inspected by Border Force or some other third party. The goods are required to be held.</td>
    <td>2</td>
  </tr>
  <tr>
    <td>Non-Blocking Documentary Control</td>
    <td>3</td>
    <td>A documentary check has been requested, but the goods do not need to be held.</td>
    <td>3</td>
  </tr>
  <tr>
    <td>No control required</td>
    <td>6</td>
    <td>The declaration has been risked and no control has been required.</td>
    <td>6</td>
  </tr>
  <tr>
    <td>Risking not yet performed</td>
    <td>0</td>
    <td>The declaration is in a processing state which means that risking has not been performed yet.</td>
    <td>N/A</td>
  </tr>
  <tr>
    <td>Pre-lodge pre-fix</td>
    <td>H</td>
    <td>The declaration is an advance/pre-lodged type, and as such that the routing is provisional only.</td>
    <td>H -</td>
  </tr>
</table>


## UCRs
Unique Consignment References are a unique identifier for ‘packages’ and/or ‘containers’ in which goods are transported. There are 2 types of UCRs which are:

- Declaration (DUCRs) - assigned by the declarant to uniquely identify a single consignment of goods which is the subject of one or more customs declarations 
- Master (MUCRs) - used to group or ‘link’ several other UCRs under a master UCR (MUCR)

You can think of a MUCR as ‘containing’ its child UCRs. A MUCR can contain both DUCRs and potentially other MUCRs (in a nested structure up to seven levels deep). The nested nature of MUCRs means that all MCUR will have 1..n child UCRs and 0..1 parent MUCR. 
