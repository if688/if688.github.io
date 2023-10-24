# Generated from Arithmetic.g4 by ANTLR 4.13.0
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
    from typing import TextIO
else:
    from typing.io import TextIO


def serializedATN():
    return [
        4,0,8,41,6,-1,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,
        6,7,6,2,7,7,7,1,0,1,0,1,1,1,1,1,2,1,2,1,3,1,3,1,4,4,4,27,8,4,11,
        4,12,4,28,1,5,1,5,1,6,1,6,1,7,4,7,36,8,7,11,7,12,7,37,1,7,1,7,0,
        0,8,1,1,3,2,5,3,7,4,9,5,11,6,13,7,15,8,1,0,2,1,0,48,57,3,0,9,10,
        13,13,32,32,42,0,1,1,0,0,0,0,3,1,0,0,0,0,5,1,0,0,0,0,7,1,0,0,0,0,
        9,1,0,0,0,0,11,1,0,0,0,0,13,1,0,0,0,0,15,1,0,0,0,1,17,1,0,0,0,3,
        19,1,0,0,0,5,21,1,0,0,0,7,23,1,0,0,0,9,26,1,0,0,0,11,30,1,0,0,0,
        13,32,1,0,0,0,15,35,1,0,0,0,17,18,5,43,0,0,18,2,1,0,0,0,19,20,5,
        45,0,0,20,4,1,0,0,0,21,22,5,42,0,0,22,6,1,0,0,0,23,24,5,47,0,0,24,
        8,1,0,0,0,25,27,7,0,0,0,26,25,1,0,0,0,27,28,1,0,0,0,28,26,1,0,0,
        0,28,29,1,0,0,0,29,10,1,0,0,0,30,31,5,40,0,0,31,12,1,0,0,0,32,33,
        5,41,0,0,33,14,1,0,0,0,34,36,7,1,0,0,35,34,1,0,0,0,36,37,1,0,0,0,
        37,35,1,0,0,0,37,38,1,0,0,0,38,39,1,0,0,0,39,40,6,7,0,0,40,16,1,
        0,0,0,3,0,28,37,1,6,0,0
    ]

class ArithmeticLexer(Lexer):

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    PLUS = 1
    MINUS = 2
    MUL = 3
    DIV = 4
    INT = 5
    LPAREN = 6
    RPAREN = 7
    WS = 8

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ "DEFAULT_MODE" ]

    literalNames = [ "<INVALID>",
            "'+'", "'-'", "'*'", "'/'", "'('", "')'" ]

    symbolicNames = [ "<INVALID>",
            "PLUS", "MINUS", "MUL", "DIV", "INT", "LPAREN", "RPAREN", "WS" ]

    ruleNames = [ "PLUS", "MINUS", "MUL", "DIV", "INT", "LPAREN", "RPAREN", 
                  "WS" ]

    grammarFileName = "Arithmetic.g4"

    def __init__(self, input=None, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.13.0")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None


