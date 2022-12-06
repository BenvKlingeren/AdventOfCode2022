package three_rucksack_reorganization

/**
 * One Elf has the important job of loading all of the rucksacks with supplies for the jungle journey.
 *     Unfortunately, that Elf didn't quite follow the packing instructions, and so a few items now need to be rearranged.
 *
 *     Each rucksack has two large compartments. All items of a given type are meant to go into exactly one of the two compartments.
 *     The Elf that did the packing failed to follow this rule for exactly one item type per rucksack.
 *
 *     The Elves have made a list of all of the items currently in each rucksack (your puzzle input), but they need your help finding the errors.
 *     Every item type is identified by a single lowercase or uppercase letter (that is, a and A refer to different types of items).
 *
 *     The list of items for each rucksack is given as characters all on a single line.
 *     A given rucksack always has the same number of items in each of its two compartments,
 *     so the first half of the characters represent items in the first compartment,
 *     while the second half of the characters represent items in the second compartment.
 *
 *     For example, suppose you have the following list of contents from six rucksacks:
 *
 *     vJrwpWtwJgWrhcsFMMfFFhFp
 *     jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
 *     PmmdzqPrVvPwwTWBwg
 *     wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
 *     ttgJtRGJQctTZtZT
 *     CrZsJsPPZsGzwwsLwLmpwMDw
 *
 *     The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp, which means its first compartment contains the items vJrwpWtwJgWr,
 *     while the second compartment contains the items hcsFMMfFFhFp. The only item type that appears in both compartments is lowercase p.
 *
 *     The second rucksack's compartments contain jqHRNqRjqzjGDLGL and rsFMfFZSrLrFZsSL. The only item type that appears in both compartments is uppercase L.
 *     The third rucksack's compartments contain PmmdzqPrV and vPwwTWBwg; the only common item type is uppercase P.
 *     The fourth rucksack's compartments only share item type v.
 *     The fifth rucksack's compartments only share item type t.
 *     The sixth rucksack's compartments only share item type s.
 *     To help prioritize item rearrangement, every item type can be converted to a priority:
 *
 *     Lowercase item types a through z have priorities 1 through 26.
 *     Uppercase item types A through Z have priorities 27 through 52.
 *     In the above example, the priority of the item type that appears in both compartments of each rucksack is
 *     16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s);
 *     the sum of these is 157.
 *
 *     Find the item type that appears in both compartments of each rucksack. What is the sum of the priorities of those item types?
 */

val input = """
    rZTmmqbBrmBvSTCwDDtlwjqnqnnq
    dhgQHhPfVgPlPdFzFzFgdptCQjtnwCntjsCppRtRND
    lVdVHWGPvTvmrrBW
    GmJBqwPLhfPBfJfvfffFmwtjDprpzVpVMpcDrVjzzcjpML
    HgWnRnWggWbNTWbCnPCgCnsjcVDrjMrdzjprMMrzcHDrDr
    SsSsRsCSPSPBvtJt
    BLtwwTBmLSTlMsjdZmFZZP
    hzbzNNrbqQbhQDDrhCprbhDCpvFJJPjMZJZgjjPdlvZjZvvl
    fbNrqrVDfdfGzqcHTBTVHwcTSHcH
    lcDdcrCDCRHJHBllPR
    tNGQwQhtzLhJBRHbPMBMjGBj
    NZZZpVqqFqpQpCTZcTnrTrnJJC
    BSNLNzbLLsMGSDLSsSBdVwTVQFdTVTtqgTwNVN
    lRjplvmWpgrqwlVFFr
    mfRCpWwvChZCBGSzZG
    mDSlGBGwhGhmLHCQnMMVMLMVFJ
    WTNfjNgzNdgNWfsgsWWcWgfrVrnnFHQbrHvFrVVdHMrnCr
    FpcggcNttFfqSqDtwBDmhZ
    HzNsHbGsddQHPrsNPNsTnNjMbjVbcVlMLjMjLtlttjjv
    CQfBZDQfWJlJlLJhvMMv
    WwwmWRfFwmCmwwzQzzzrdGNHFzNT
    JDvhJfdZZTdCTnmmTH
    qbPcsqbjcbstjbgnvqpRCBTCmgCm
    WPbPtbtVjWQsPvSVzSZLMDMVfLZJ
    NjMbTZPjHjbdBqNBqFqDFz
    LCcLSRLStRrLHShCtRfcpCtpQVqqDFDFqDdFpBddDQQFdB
    htCGtrSJLfScvwJvggbgwHgW
    hmPTmfFPwBFHhsBstJldltstVDSVrrpD
    CjzNGQjnRMMvMngMLGRVRBltVrVppqptVSqlVJ
    cLBjgjGGGCgvLLnhZThwcfTHPTcPmw
    SzwsVwcGsTVTmzmgjsLsmWWnGJZbbJbZtZqnDJntGq
    NHQvpvNRflHvQpPMlbtbZqbFDnWlqVrD
    dpPQVdpHMPRBpfCszCmsLsmcjdSg
    wZZGGrnGVvZGPTcTnGvVCVpmpJSgCJtNpWgWVgmC
    MdMRqqzMLDtQDQmzJg
    HBMdRLLBLBdbbBLHlRjLrHPPnTvGtTcwhGrhZtvh
    fcbcPWmvPvftWbDNVJJDrrhsJs
    wQvzqvpQQzHQwTTNVhrBGJTJ
    ZCMvzHMRCqggmWmndPngnn
    VjvVJvjdgjJNTVgdpjRttsTHSsbFqqRHSbBR
    nrfZLZCZnLnCCncZCrCQLSsFHHqtsSsSSBcHGtHsFh
    nQlLMrmwZtmwCMmMwZmtLLggvNvVjjNJglpDgzNdJJvN
    bCjQbTzCBlCvpqPTbZphtWWRhtddmDRRdRhPhh
    sLJsnJFcsnJcMMjNnfsjDDcDWcRgggtmwVRtVmhh
    sMsJLFfGrfFnrSNJjHzlTCCCQzpbBpzQzSBQ
    gWRzWwcrzWcgZHRzHmcpTLTgTLhQDSgFFLTpLD
    bBJfvJCssGJNjvPmbbmbLTQFTLQp
    jsCqBJsVsGBqCfNcWMmrRWlWqmwMcz
    cLjncLlQbllRhlnQTRblwtndsgpWdqgmnWNWmGpvWzdgzz
    DrFJBFFHZrrDDVJSNmpsWdzVpmzdqqzpzq
    FJPPHfDJPDPCZSZHFSDPCJtwRjClttNbwwjQLjcRhLlb
    tZZRtWCRtsspLRqSVqbPDfVvlfFDqV
    dgvMcccHHDHNrrbf
    wGwdgBBhhcBhCvTZvtCppp
    LRRNFfffFzzcrGRffNfcGNzJnrnhjdDMHHnrWdlmhddHnjrh
    BvStvwSqqCZVqtvpZBWMMhhFhWdmdMWMhm
    TTvqSbwqTPpZPzQsQRffsFGQ
    phZZpGbGVmqDbPTF
    tlNwlncnzwddcrGPlFmjlTTlfmjD
    zntnczBMdvBnnvnthHHZMJhCLpZSSRGQ
    ZwLLnbCDfClLZzZwDzCCZDbmNNdNtdBVNTNdNWMFtTFzTVFd
    vlPlJRgRhQcPQQjpcRQJBBthNdtddtthtFMNWqMq
    ppJgsgrJpJgslgrgRSPDDDLZLnHbrLHbwLbHfb
    sBrNSTsrgDDMSjpPWVVqhppbsbtz
    HTJfHwFwRFCnCPbzbzVzbVWq
    QTcvvcmHnwGvvnRNrLglNNLNDZcZZL
    qNNHSSFgbhLHHNfBwlJjQwwBcwQN
    WZnVrZrMpVvZmVjwBvzBQRflJJcz
    pWVGpWnmrmWjDmtnWVVZmtPFPCSbPgqgLSqtHCgTHgHH
    QcQHqhpqQGbvbqHNqfhsQfHczZMlBZdZBlSFFZpZlFMDRFBM
    TPVgmmrjtWjwrtwgLmTwLPMDZlMDMnSzzZgglzldBlgZ
    PVtPrmPddrPCVTNqcHvQbHsCQNGh
    PnsrrsdsSrnCvJCJBVwNqcHPRwNLWHwV
    pjTQlgGWMjZBbRHHHZcbVV
    htpThhlMjFdWrtDrfrsn
    GZjHFHgjpbZQbgpHdgpjjBMTQsMJWzWRcsLMCRWzcz
    ltwPlhwPSlwmmDhfrMwlzLLTSWJRssCBJWzsccCc
    nfrnrntPnDmDDnPrwmvlVGdGFFNqjVHNjbGFjgFNMp
    BjHBvHHqnBHrnnvclqjqplRRRQSfRpJQwPswStJsJQSt
    wVFGWdVZVhWVDzVdZDSfRJtLLZJPtJRJSfJP
    TDhCdWmNwzTWVmDBvMlrHmcqvHBMng
    HpDpHvjvCjDHZHVWJSCrnrJgnNwr
    rtQhssBTlRMblLBTtNnJFVSnnwVVwVWNnb
    BhrchlmBBszfjmzzffDf
    MMcJtJmVmnppVmSSpbCRvDvDRLDqvBRRCCMC
    GWNNGGGfrjlHHHNZZZLNZt
    jGrgfFjQrdhlhhgQFrVpnpVgmStPSJSPzJPP
    wvJNJNtfGGphQQjFdGWj
    DzSLzPczBrqzPrLMjSpjWMlSpQgwWd
    zPHRqBLqqHzPcBDPsznZCwJsnfVnmZmtVntC
    ttVWftWgGlWGfgtLtNddrNDdNvsLrdLdNm
    JCcFSnbBqbRbSBCBqTFSQCmwMjRsrDRNNjDddssNfDrr
    cBHBTTQFJJCCJQcCbCcqnSftHtZhHzWghPzVZpPglVVW
    ZfSGFQdbrHQSbFFqlwLjCjLPlqwj
    gmWJgNppJrgMcchzhmzNczqRsVRCjVRVsWjVRLRqqCVq
    zDTchzJJJhgJJmBJhBTJBggtQHGrdbfnHHDHGvftStvHdf
    LdRCgCDvCbCdnLnCvpGtQlhffNlhtSlQNtQlhb
    BTJTVFJrqMVmBmdTMFNHNVQQQSHHffQhNlHQ
    MqcBmqPdFBdjPPBTJqpZDDpgGDpgWCcvGCLp
    gzFbjgqljdqblbbddBZTMvTBdMsVvm
    SHpGWBCtSPhNpPSSSpwSNGNSTLTVVsZsLrvRrRvVLLRCvTvm
    NwhHwPhDtSGpbDcBQqczbBBj
    BhzLDSflLlTTRfqGpJZZQsqfNF
    ndCmMHHRPbCjCwVPVmjtwdMVsNGJQpZQsJqJqNJdFqJZFrNq
    CtwbRcRbttHBSgTcgShvTz
    pffmzCtppTSWtzdhbJdZvvHVnvdHVV
    WMlLWRGGQWMGrQJcVbvbHnvQHbhv
    LFwRFDlqFPWfTszp
    sbfFTbbbzJzfbJZSbnsnfTchGWWJGlhWvvBGltgVttgWgg
    LLLDpHwMDLmNjmChVWWBwthrGQvgQl
    dLMLDMLBNddPHmpMPfqPcPzcsSbbccqb
    MNGMPvHTnfTfgSFrSMMgwFMw
    QQRpjBsqhRQsldpqRQQQmjZFtrrzSFFccvSWwwjwFWZS
    smsBbQlRlmDpDBqpqblpLbLLfTfNVPVVGnTvTLbb
    gsmFlVCShjVwNNDNgWBNHg
    dMtQvtQRrtbLMqMnqqsq
    GQfGQPRtrPddPtvcvcQZRvRpJlVJFTlpZTVJpFJsSCFJjh
    LFmpcmhNfhhnjStshM
    qWTCCQrqlQBQcJCqrJdlHDdnRtngRStnPjgDSgSsjM
    CZWrqTbllrClJZWbVfmmZcvVzmGZmfpv
    qJLCqjwjjJnFqnDQQfqlQMfMQlMg
    zmHWPhGGZVGpcCWMsWRRfBBRDs
    bdpCcGmZdNFTwnSjrd
    TttqjWvQjZTtzwWtdBCMdBMqdGCBRnhR
    bpJlcNFVzbcBhCMMCChbMP
    cJVgrplDcslrlrpFzwTHQsSTWLQtjWvLWj
    hWlmVhlpcNpScSVtNbjrbGqdHGjgQrdrRdqG
    LPBDCvFszTCzFzFzBBffHrJrrGHRHsgRjsjrjJqc
    DTCMMzzvvnDvLvLDTTBTCMFBpWpthShmwmmWmwchptnhwWWt
    dfHqNQSQQNQBHHZJfJCMCfVcRJCZ
    GjLrDjgvFrFzjDgPGvLzgmmjCslRZMMCststJMlRcPVTRJJM
    vjmmvrnzDDLVzrdSWNBQnWwdhHhH
    jTmMBMNBTVSqNgBTjgNMqMTgWZttCmLfpQQZQWtLCdCGGtWC
    zzVVbhFcbzstWCZpsftsQZ
    whwhwPnDhHRhbRVHcSNllvMnNnjMjSBJMl
    nSvQgHWtZvHlgtvqgqngjSFFFDNSfsbbbjGfcsSr
    PPVRdNwRLhdLLCCwbscBBfGfbLjjjDbs
    zVPPhMhMmhhVppRpMNRPhMQnHqZtHZvgQzWgQgvnqnnq
    JdFHDSShfgDNMhGTBlwGGJqjjJTr
    PCnWnsvpzPnmLvmsQGRGWrwlWbljwTjFGl
    PtnLzQCQLfSFctdNhN
    cTrjrCNrLjTFCTrLCdSVNVlJVSVVGJftNp
    swQHQDsQGRZGffQV
    ggffMhhvgswDgDnhhfCcTjrcTjWBWCMmcjjc
    wGHvHCvWlMLlhGWwvvwlNnRBRdDNDBLDRVVDFdBD
    MtJJTPTTQNFRNFRfTn
    crSsmmJjmtgWmMhwWMCw
    sQQHWGsWcWWrZQQshNtHFNBCNBqHFwHB
    jSLbMSdfjSjFtFghNtFBMt
    RSdmtLmSLLzSLdjjdTTbVvsVVsvZcZQzWPWcQrrW
    PCCTzTgDgzVZZLgcgcdswMMMgs
    hSrqdqRQSjqtNqcsGWcGLwMGMf
    tlQJRJSRjpJjZPdpDTdHbzTn
    pqBGDDtQBDLVhfCtCZVV
    bTNFcljgbdlFjbldjFdTTcfZqZVsLhgfVLhVhZVHfZwC
    McJjFbvTWvmRqGRr
    JRcsJDfgncfHnqSBqGSTGQsTTz
    vlBlLlpNWpPhVmTQpQSzqbqQ
    CBPvjFNMlFhCCRtZJZZHfg
    RFQQTdQQLtThDhfRcHdLfFcHJCWtbbPnJWJPNJbnJsvstvJv
    ZmMlMlwwMrVzwVqrSqmZrqbplpNWFbWJnvvspWWNslNs
    gwwmFrgMGgFqGTHRhHjDRTHH
    dNfQvLdQsvSLsHsLBgNWVggJJCWCDJgnJJ
    ZTGcflFlFRfhbwhbPcbbbWVWrMVMnDJCCWmVnDJCmF
    lTfZTpjjZhPhRcqtBtsdSQpqQvtv
    frfccJzjTBwWwcJwjrwcBVCVTRCGnpsGGSmpVSSpDH
    hhhvghZvZlZvghPbdtqGpGVCRHGGmsRmpsvGRV
    MdPCNqdtgZdZgcWMLzcffBcWzM
    LdsfZNRsRWvvfLSsCpSgCDJbPcCp
    MqTVtHHThllGMthlBHzcSzGGSFppPgbJDFbF
    nVHwVlHmlhRWdjjjLvwD
    whhWFjjzhGmGCrFFFzvtZsLZVStNZWLNpvtv
    nqPMBdMQBqJnnfqdsSNfpvtZsSNtNpLp
    HJHnQHqQlhwLlhzmGh
    nMlmnfHmfjjmflLlLdzJTrsrBLJJLBbBSJrJ
    pZRpFFDWctFPNtWvbbrTqrszTbqbcBqr
    RpRGNPPvPFsNvflmdfwMGHhmmH
    PjPzphfpJFPvFRHDbP
    QlLlBcvBvnWCWcVCnFTTSnFDNdSRRRHN
    sVtlVcVtmqjMJphrfvJs
    dRRHRfrdRHHlCTTprlNCvhVVvhzpQhVvtmntmhtz
    JMDJBLwQMBDDwZgJnhSzhmWStMvzbbmm
    PPwJwGqPGQcDcHHjCqRlRCjrCN
    GgGgbGSGzGbMBBzGDVFbDMRpmcWWTTfcFTchsJdcWJchTsch
    NCqCttLZrCPQtNrtWqfhWJJqscmTJwsc
    ZClvLCLmPjnPllPvCLrmnDRjpDzGpMRDRRDBGBgSzb
    tvwCtDMQvJJPJtvQprjrjrvBjsTZTWTj
    gFzgldFZSlSbgFlZmGmcFqsppjsLqrBsLBrqqWWjdB
    FlcbhhNNbmHmcbSSzzggwDDQDwJnVCVHPtMVnnZQ
    hrCnnrFrCvFHzVFdmmFm
    GDTBsSfDDBRwfDsQbSdjHHVlqpmpgqWqpH
    TBDBDBQBwcsPsPGQswPcZvJMrJhnrNhrNNnHJM
    CztfzfZLBjMqZZWZgT
    VPcblQhJvtgbvbgb
    wwFQwVRPRchwcrJcPzfRpzspBfzfnSCzmt
    FMnmnQnFNdQFRtmFmfNsCsjfpfrHHfVffV
    DlLqDPwGlbVCdVbddbsr
    GPDzLhqwLqDMFdFJRWzQzd
    CSDSrMqnVSCTsPGPZpnPPGvP
    jhBhhqBQQlhgjthBhlhJpLlwLLPwsswsGZpWPLvP
    dgJQzgFjzjJFzzdHFzzzJMmNHCrSMSCSNbRqDCMCmR
    cvSPvzWwzcTbVWSPbppWVjsGjdHdQSlNsQSdNGqsHZ
    MRmCfmFBfRJfjqrdNMZHZQjQ
    qgFtChDCFgmCnppPnczPbcLpnL
    RllsdrhQvcVqmVzQcm
    gGgnrZZMrFWFpZcccVmHqjVmHHnJ
    ZrMWTTbbGMpbtgCTTZgZCWCLhwdsLvhhhPhNSldvPwPNfNlR
    ffMqqznPPMzHfdfcdBJGTMVTGjRmMMTBjr
    vtDwSwpmDsmQZswWSDhhDQGrjTgJBglRsjTTjVRBVTBl
    ZthhQStwppSSvbvNDtWwnnbffmPnHPFHqmzFbLFq
    CcHPmPcTJTqNCPqbqJqLgNJrjWtrftjrrnBnsWtjtBsfTB
    ZRLwhzwLRlhLpdlpjftBBnBjWsBBvn
    QhzhlwDdMzwFSwRLMJqqcSmqNPgmqNHNVP
    WzTWppwcQNppbQrJHhhrJfcdfnsr
    MDMLlLqjvqSBvVCLGJhnJsrDnnrDdhDffZ
    BLMCBCBlLlGSJvSPBMLqGJVwwQzPpNRWmTRzmzpWWFmTbQ
    WpWpWsfcBFjwGgqqtTQrTpgg
    JLHNPPvLJRZdnNJZHRzGGTzjrtMqMJlQzztt
    vHHnbDnLnHRCRnvdZdbHLNPfBfBhcffmcSSsDjcVwVBmcS
    DDZlblRRLQcNpJNhpL
    VPrdJfBFFBBWBrdvJPCBBdfhqcFhchNQcpNgzqcjphqFjp
    mWVPfMWWfBMWWwPrWvJHDbZGZmZRtDbsDbSb
    PDwwBzvRRzPCBPgnrwvvCDsSSccWscFTnSshWnZsSZcF
    GJtNGHfLbQtQQJQGhhhShgSZWVWJjSFF
    tmHlfGfMlBzrRDMggz
    gSBNwDNJglSwlDMtTCsZzStTsSCC
    hhfGdGcFhrqFmQddrhvvrdGRRtQMTHMCsbZbZtRTsbZsQs
    mrmrFqqqccdhWjGcnLpBDWgNWpCBlgLW
    WgmBsqMBnLLGnGnJtFgbbTwHttTwHF
    cQjcfpVQfCCPSMjCcCPSPjVwbtTlTtwJbTvJJHbzHFFJ
    PCZDCZffCdpQCdDWrGGsnLqWhnrM
    gppVszSgMPMPstzNpPMQpnGfDJhfnGLLGnfLfQlLfh
    rBFcCcrbmbJJJWhbhLVL
    wqcmRFZqmcvvCZBcRvcVwNsztSPzHstSgzMNSgpS
    qzLJRZfpRZtNNMSfftFN
    QDnPHCCGvbQnnCwMMlcFgsgHFFlNlV
    rPCMQnbdhRLqJLzhzB
    dfdrfqBqBtRwBsFR
    cDczzSMzDcSGSQbCfFjRFZtZCZmtwZRt
    bVcJSbVbSDllNrrWWNdvWf
    WSPPWlppCQlZPGqPjhcjfs
    JJrJrRTHNTNLbbNLcfzzSfSzGTjsqZsj
    FVRFNgVRbDbdwlWpSnvQnVQM
    znJTCRCSvRpzVBjWJdBBBVNb
    gggcfGDrGDZqwhwfGBjbHVSVdtdjtBShWj
    ZrgmqmGDGfDPmrfwPmsqZPfCpsFFnFvlSMCLLvpSRFFMvL
    qhhfgzzSGDSZSgfrcjhcjCCndnbjdr
    FPTTTwBHBPJMJVJBGwmjvCmBdjjNNcrjncNc
    GwTttMsTtHFtVFtDplSDzgRpDqsfpD
    vzwsPlvFFdJGjQwdJw
    HHNbpDTbVMvTpmMHvddtRtJJjjJRdLmLGj
    HbqHcbMvlWrqzWFW
    hMJMJBhPTnDMJJTGmmGmwDpRzRpFWz
    lSZPPNvbNllPpGRFwwzRNGgm
    bHZCZbvrttlZClqbHbsrbnQMThdJBQhVQBPdscnPQB
    ZRNZfffHLfDLgfNlHWwhChWzzVdcVH
    jpJmJjvnTtSjtJvQWldPWcBdPSdWzzcz
    jGGsGsFFFGnJtTvvTszZNqqNgrsDLRDqLqrL
    rrblpnfnVVfspgrppnMrpsrGdGdzgddzPFCjCzjzzzjtDC
    TRWTJwThJhRvwZWvJBZvqDzQzGBPCzdHGjdGGGttzj
    JSZmTZZwWvqhwqrrVnrLnPmbsbPr
    MdhjZhZZDTdPDcgCSLfgCpCL
    vvwtnwnssznwJnwvBbBBHHRSSfLLcpWfSWWzcLRTRWpf
    snJtHJHmbBsrswNtsnjhlhqZPqTjjTjQMPGr
    gmSnWMMzvvNWCNWCJJph
    QfqjcbcRGGjcwhNppNqMptdNHL
    rGPbflPfwPvlFFvTTMlg
    trTdMJvtlLntbCRN
    GBZsGFGBcRbZCRNR
    SSGFmFjqVNFVssjSVjqjvMMQvgTmMgMMQWMmTdhJ
    GcNcdNdwMZSqNZSSScSdqGwDrCmJMVrCmHmVVCFVJDrmFV
    jTvsRsWbjjbQQfvTThFVZVTVDJVHlCFr
    BjnBPfRWBnRsnvBsRBQQSSGzpZLdgwcLZqzgzPLg
    clNrNpjbNpbRrCpsRlrVtjwVZwttttZVgMHwZS
    FJBBDhJDTQFThqssvPJBBvHMWLwgwSHtWLZMwZgwSg
    qQJfdJDhGsBBDFJBnlzGmmnRzbCpcrzl
    ZPbfgBvcZPPZPWWWWBFbQllndnqdnlpwdSNfnwdN
    LzLrzDhmDRRJpJzptDhCSCqHMHqnqSlHqMSQNHQS
    zTsRzsDTJszzrrLRstrGJLsPpbVVPbcgTBcZvbPVFggbjP
    THpVHSrLZrzzvPtJdtsqLssdLW
    fbfCCQgQllWwwwFmjRsPcqcPsJJJdscPdmsP
    RNQlQgCFfgwVppWTNvGrvn
    PqFwwcqzDlFJDDQVMjQmMBjG
    ZgTZZndCpBMVNTvvQc
    pHgtZdtRnnLhcshdhWzWSFlbsJsqzzzbSb
    zjfgjMhhgMJdfHQHWdVQvR
    CrmpmpZpHQptHHHQ
    CnwcFbNCqQBFwwFFsPslJgsjhMlMcDJP
    HpnStLpnQnHnqQLQqpMSSWWZbswNcNqwbNsfwqGGZc
    dVRRTCTVJNLcfJcJFb
    gzjTRCddgLDdzdjCCrBjjdhhBnQPSSBhvlSBQvMhQMnt
    lFTlwMwZlblSjrCpVvvsptspZpps
    nHRPPnqnhPRqJHhqqhfdPqLCHvBCvvscvVNczztCCvsvtm
    RJDghDhRhhGPPqGhsPhhFSbbwGSFjGQlWTrbwQbW
    RRjgNPTRFhglgNNjTsmGqCCGZfzmHCnZGnZCqq
    SppWLbtbCzZMpHMZ
    dSDbbJdVVlHFNlll
    dtZdGmqqtmzhtqZtZswzSnSjfNHNVjzCWCnCffHz
    LgpMFMvlhvRMhhDDlvvQLFJCfSCHnFVJnSnJHNjSnj
    rRBLcQcpQcrZbwsZshbs
""".trimIndent()
