# Collaboration Instructions for Markdown Notes

> [!info] If you're interested in collaborating on these notes, please follow the guidelines below to ensure consistency and maintain a high-quality resource.

## Requesting Access

-   If you wish to collaborate, contact me to request GitHub permissions.
-   I am using the MKdocs template to upload the notes.
-   If you are not familiar with how to commit and push changes, search GitHub for instructions.
-   The notes are located in the `docs` folder – this is where you should make your updates after copying your own copy of the repository.

## Rules for Creating a Note

> [!warning]
> Before you start, make sure to follow the rules outlined below when creating a note.
### Naming and Linking Files

-   If you want to add a file from a module, name it in the format: `Modulename_01.Lecture1`.
-   Add a link to the file in the module overview page of the notes.
-   For tutorial or recitation files, use the format: `modulename_tut01`.

### Writing Summary Notes

-   When adding a summary note for a particular topic, write the document using **markdown**.
-   Start the document with an `h1` heading for the topic name, and use `h2` for subtopics.
-   At the beginning of the document, add a foldable resource callout section to include links to lecture notes, videos, or any other relevant resources.
-   Throughout the notes, you may reference PDF notes using markdown links.
-   Aim to make your notes concise but understandable.
-  Place the notes on the correct folder (normally `mynotes`)
-  Add a link of the file on the module overview page.

## Example Template for a Summary Note

```
# Topic Name

>[!abstract]- Resources
>[Modulename_01.Lecture1](../Notes/Modulename_01.Lecture1.pdf) - [Video](https://www.youtube.com/watch?v=example)

## Subtopic 1

Content for subtopic 1 goes here. [Reference to PDF notes](../Notes/Modulename_01.Lecture1.pdf).

## Subtopic 2

Content for subtopic 2 goes here.

### Sub-subtopic

Content for sub-subtopic goes here.

```