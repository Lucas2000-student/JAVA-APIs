package org.acme.service;


import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.FaqEntity;
import org.acme.repository.FaqRepository;


import java.util.List;
import java.util.NoSuchElementException;


@ApplicationScoped
public class FaqService {


    private final FaqRepository FaqRepository;


    public FaqService(FaqRepository FaqRepository) {
        this.FaqRepository = FaqRepository;
    }

    public FaqEntity createfaq(FaqEntity FaqEntity) {
        FaqRepository.persist(FaqEntity);
        return FaqEntity;
    }


    public List<FaqEntity> findAll(Integer page, Integer pageSize) {
        return FaqRepository.findAll()
                .page(page, pageSize)
                .list();
    }


    public FaqEntity findById(Integer IdFaq) {
        return (FaqEntity) FaqRepository.findByIdOptional(IdFaq)
                .orElseThrow(() -> new NoSuchElementException("faq não encontrado com id: " + IdFaq));
    }


    public FaqEntity updatefaq(Integer IdFaq, FaqEntity FaqEntity) {
        var faq = findById(IdFaq);


        faq.setFeedback(FaqEntity.getFeedback());
        faq.setSugestao(FaqEntity.getSugestao());
        faq.setFaqNome(FaqEntity.getFaqNome());

        FaqRepository.persist(faq);

        return faq;
    }


    public void deleteById(Integer IdFaq) {
        var faq = findById(IdFaq);
        FaqRepository.deleteById(faq.getIdFaq());
    }
}
