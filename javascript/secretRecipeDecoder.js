const ENCODING = {
    'y': 'a',
    'h': 'b',
    'v': 'c',
    'x': 'd',
    'k': 'e',
    'p': 'f',
    'z': 'g',
    's': 'h',
    'a': 'i',
    'b': 'j',
    'e': 'k',
    'w': 'l',
    'u': 'm',
    'q': 'n',
    'n': 'o',
    'l': 'p',
    'm': 'q',
    'f': 'r',
    'o': 's',
    'i': 't',
    'g': 'u',
    'j': 'v',
    't': 'w',
    'd': 'x',
    'r': 'y',
    'c': 'z',
    '3': '0',
    '8': '1',
    '4': '2',
    '0': '3',
    '2': '4',
    '7': '5',
    '5': '6',
    '9': '7',
    '1': '8',
    '6': '9'
}

export const decodeString = (encodedString) => {
    // returns encoded value or the input, if no matching value
    return encodedString.split('').map(l => ENCODING[l] || l).join('')
}

export const decodeIngredient = (ingredient, returnType = 'object') => {
    const decoded = decodeString(ingredient);
    // split by # to extract the units and description name
    const [amount, description] = decoded.split('#');
    if (returnType === 'object') return {
        amount, 
        description,
    }

    return `${amount} ${description}`
};

