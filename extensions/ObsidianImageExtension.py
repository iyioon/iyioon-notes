from markdown.extensions import Extension
from markdown.inlinepatterns import ImagePattern
from markdown.util import etree


class ObsidianImageExtension(Extension):
    def __init__(self):
        super().__init__()
        self.config = {}

    def extendMarkdown(self, md):
        # Create a new pattern that matches the Obsidian image syntax
        pattern = r'!\[(\d+)\]\((.+?)\)'
        image_pattern = ImagePattern(pattern, md)

        # Override the handleMatch method to add the width attribute to the image tag
        def handleMatch(m, data):
            el = etree.Element('img')
            el.set('src', m.group(2))
            el.set('alt', '')
            el.set('width', m.group(1))
            return el

        image_pattern.handleMatch = handleMatch

        # Add the new pattern to the Markdown parser
        md.inlinePatterns.register(image_pattern, 'image', 150)

